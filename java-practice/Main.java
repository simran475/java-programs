import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final UserService userService = new UserService();
    private static final BookService bookService = new BookService();
    private static final TransactionService transactionService = new TransactionService(bookService);
    private static final ActivityLogService activityLogService = new ActivityLogService();

    public static void main(String[] args) {
        userService.seedDefaultAdminIfNeeded();
        System.out.println("=========================================");
        System.out.println(" WELCOME TO THE LIBRARY MANAGEMENT SYSTEM");
        System.out.println("=========================================");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Register (New User)\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": handleRegister(); break;
                case "2": handleLogin(); break;
                case "3": running = false; System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid option, try again.");
            }
        }
        sc.close();
    }

    private static void handleRegister() {
        System.out.println("\n-- New User Registration --");
        System.out.print("Full name: ");
        String name = sc.nextLine().trim();
        System.out.print("Desired username: ");
        String username = sc.nextLine().trim();
        System.out.print("Password: ");
        String password = sc.nextLine().trim();
        System.out.print("Contact (email/phone): ");
        String contact = sc.nextLine().trim();
        System.out.print("Role (STUDENT/ADMIN) [default STUDENT]: ");
        String role = sc.nextLine().trim();
        if (role.isEmpty()) role = "STUDENT";

        User user = userService.register(name, username, password, role, contact);
        if (user == null) {
            System.out.println("Registration failed: username already exists.");
        } else {
            System.out.println("Registration successful! Your User ID is " + user.getUserId() + ". You can now log in.");
        }
    }

    private static void handleLogin() {
        System.out.println("\n-- Login --");
        System.out.print("Username: ");
        String username = sc.nextLine().trim();
        System.out.print("Password: ");
        String password = sc.nextLine().trim();

        User user = userService.login(username, password);
        if (user == null) {
            System.out.println("Invalid username or password.");
            return;
        }
        System.out.println("Login successful. Welcome, " + user.getName() + " (" + user.getRole() + ")");
        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            adminMenu(user);
        } else {
            studentMenu(user);
        }
    }

    private static void studentMenu(User user) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- Student Menu (" + user.getName() + ") ---");
            System.out.println("1. Search Book\n2. Issue Book\n3. Return Book\n4. My Transactions\n5. Logout");
            System.out.print("Choose an option: ");
            switch (sc.nextLine().trim()) {
                case "1": searchBookFlow(); break;
                case "2": issueBookFlow(user.getUserId()); break;
                case "3": returnBookFlow(); break;
                case "4": myTransactionsFlow(user.getUserId()); break;
                case "5": loggedIn = false; System.out.println("Logged out."); break;
                default: System.out.println("Invalid option, try again.");
            }
        }
    }

    private static void searchBookFlow() {
        System.out.print("Enter Book ID, title, or author keyword: ");
        String keyword = sc.nextLine().trim();
        List<Book> results = bookService.search(keyword);
        if (results.isEmpty()) {
            System.out.println("No books found matching '" + keyword + "'.");
        } else {
            System.out.println("Found " + results.size() + " book(s):");
            for (Book b : results) System.out.println("  " + b);
        }
    }

    private static void issueBookFlow(String userId) {
        System.out.print("Enter Book ID to issue: ");
        String bookId = sc.nextLine().trim();
        Transaction txn = transactionService.issueBook(bookId, userId);
        if (txn == null) {
            System.out.println("Unable to issue book. It may not exist or has no available copies.");
        } else {
            System.out.println("Book issued successfully!");
            System.out.println("  " + txn);
            System.out.println("Please return by " + txn.getDueDate() + " to avoid a late fine.");
        }
    }

    private static void returnBookFlow() {
        System.out.print("Enter Transaction ID to return: ");
        String txnId = sc.nextLine().trim();
        Transaction txn = transactionService.returnBook(txnId);
        if (txn == null) {
            System.out.println("Unable to return: transaction not found or already returned.");
        } else if (txn.getFine() > 0) {
            System.out.printf("Book returned late. Fine due: %.2f%n", txn.getFine());
        } else {
            System.out.println("Book returned on time. No fine due. Thank you!");
        }
    }

    private static void myTransactionsFlow(String userId) {
        List<Transaction> txns = transactionService.getTransactionsForUser(userId);
        if (txns.isEmpty()) {
            System.out.println("You have no transaction history.");
        } else {
            for (Transaction t : txns) System.out.println("  " + t);
        }
    }

    private static void adminMenu(User admin) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- Admin Menu (" + admin.getName() + ") ---");
            System.out.println("1. Manage Books\n2. Manage Students\n3. Issue Book\n4. Return Book" +
                    "\n5. View Issued Books\n6. Defaulter List\n7. Record Library Activity\n8. Logout");
            System.out.print("Choose an option: ");
            switch (sc.nextLine().trim()) {
                case "1": manageBooksMenu(); break;
                case "2": manageStudentsMenu(); break;
                case "3": issueBookFlowAdmin(); break;
                case "4": returnBookFlow(); break;
                case "5": viewIssuedBooksFlow(); break;
                case "6": defaulterListFlow(); break;
                case "7": recordActivityFlow(); break;
                case "8": loggedIn = false; System.out.println("Logged out."); break;
                default: System.out.println("Invalid option, try again.");
            }
        }
    }

    private static void manageBooksMenu() {
        System.out.println("\n-- Manage Books --");
        System.out.println("1. Add Book\n2. Remove Book\n3. List All Books\n4. Search Book\n5. Back");
        System.out.print("Choose an option: ");
        switch (sc.nextLine().trim()) {
            case "1": {
                System.out.print("Title: ");
                String title = sc.nextLine().trim();
                System.out.print("Author: ");
                String author = sc.nextLine().trim();
                System.out.print("Number of copies: ");
                int copies = parseIntSafe(sc.nextLine().trim(), 1);
                Book b = bookService.addBook(title, author, copies);
                System.out.println("Book added: " + b);
                break;
            }
            case "2": {
                System.out.print("Enter Book ID to remove: ");
                String id = sc.nextLine().trim();
                System.out.println(bookService.removeBook(id) ? "Book removed." : "Book ID not found.");
                break;
            }
            case "3": {
                List<Book> all = bookService.listAll();
                if (all.isEmpty()) System.out.println("No books in catalog yet.");
                for (Book b : all) System.out.println("  " + b);
                break;
            }
            case "4": searchBookFlow(); break;
            case "5": break;
            default: System.out.println("Invalid option.");
        }
    }

    private static void manageStudentsMenu() {
        System.out.println("\n-- Manage Students --");
        System.out.println("1. View All Students\n2. Remove Student\n3. Back");
        System.out.print("Choose an option: ");
        switch (sc.nextLine().trim()) {
            case "1": {
                List<User> students = userService.getAllStudents();
                if (students.isEmpty()) System.out.println("No students registered yet.");
                for (User u : students) System.out.println("  " + u);
                break;
            }
            case "2": {
                System.out.print("Enter Student User ID to remove: ");
                String id = sc.nextLine().trim();
                System.out.println(userService.removeStudent(id) ? "Student removed." : "Student ID not found.");
                break;
            }
            case "3": break;
            default: System.out.println("Invalid option.");
        }
    }

    private static void issueBookFlowAdmin() {
        System.out.print("Enter Student User ID: ");
        String userId = sc.nextLine().trim();
        if (userService.findByUserId(userId) == null) {
            System.out.println("No such user ID.");
            return;
        }
        issueBookFlow(userId);
    }

    private static void viewIssuedBooksFlow() {
        List<Transaction> issued = transactionService.getIssuedBooks();
        if (issued.isEmpty()) {
            System.out.println("No books are currently issued.");
        } else {
            System.out.println("Currently issued books:");
            for (Transaction t : issued) System.out.println("  " + t);
        }
    }

    private static void defaulterListFlow() {
        List<Transaction> defaulters = transactionService.getDefaulters();
        if (defaulters.isEmpty()) {
            System.out.println("No defaulters. Everyone is within their due date.");
        } else {
            System.out.println("Defaulter list (overdue books):");
            for (Transaction t : defaulters) {
                User u = userService.findByUserId(t.getUserId());
                String userName = u != null ? u.getName() : t.getUserId();
                System.out.println("  " + t + " | Student: " + userName);
            }
        }
    }

    private static void recordActivityFlow() {
        System.out.println("\n-- Record Library Activity --");
        System.out.print("Activity type (e.g. BOOK_UNAVAILABLE, DAMAGED, LOST, NOTE): ");
        String type = sc.nextLine().trim();
        System.out.print("Details: ");
        String details = sc.nextLine().trim();
        activityLogService.logActivity(type, details);
        System.out.println("Activity recorded.");
    }

    private static int parseIntSafe(String s, int fallback) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return fallback;
        }
    }
}