import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton login, clear;

    Login() {

        setTitle("Login Form");
        setLayout(new FlowLayout());

        username = new JTextField(15);
        password = new JPasswordField(15);

        login = new JButton("Login");
        clear = new JButton("Clear");

        add(new JLabel("Username:"));
        add(username);

        add(new JLabel("Password:"));
        add(password);

        add(login);
        add(clear);

        login.addActionListener(this);
        clear.addActionListener(this);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {

            String user = username.getText();
            String pass = new String(password.getPassword());

            if (user.equals("admin") && pass.equals("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }

        if (e.getSource() == clear) {
            username.setText("");
            password.setText("");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}