class BankAccount {
    // attributes
    String accountHolder;
    double balance;

    // method to deposit money
    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
        } else {
            balance = balance + amount;
            System.out.println("Deposited: Rs." + amount);
            System.out.println("Current Balance: Rs." + balance);
        }
    }

    // method to withdraw money
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdraw amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
            System.out.println("Current Balance: Rs." + balance);
        } else {
            balance = balance - amount;
            System.out.println("Withdrawn: Rs." + amount);
            System.out.println("Current Balance: Rs." + balance);
        }
    }

    // method to check balance
    void checkBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Total Balance: Rs." + balance);
    }
}

class Account {
    public static void main(String[] args) {

        // creating bank account object
        BankAccount acc = new BankAccount();
        acc.accountHolder = "Ram Sharma";
        acc.balance = 1000;

        System.out.println("===== BANK ACCOUNT =====");
        acc.checkBalance();

        System.out.println("----------");
        acc.deposit(500);

        System.out.println("----------");
        acc.withdraw(200);

        System.out.println("----------");
        acc.withdraw(2000);  // insufficient balance test

        System.out.println("----------");
        acc.checkBalance();
    }
}