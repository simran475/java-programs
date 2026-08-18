import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Multiplication extends JFrame implements ActionListener {

    JTextField num1, num2, result;
    JButton mulButton, exitButton;

    Multiplication() {

        setTitle("Multiplication");
        setSize(350, 200);
        setLayout(new FlowLayout());

        add(new JLabel("Number 1:"));
        num1 = new JTextField(10);
        add(num1);

        add(new JLabel("Number 2:"));
        num2 = new JTextField(10);
        add(num2);

        mulButton = new JButton("MUL");
        exitButton = new JButton("Exit");

        add(mulButton);
        add(exitButton);

        add(new JLabel("Result:"));
        result = new JTextField(10);
        result.setEditable(false);
        add(result);

        mulButton.addActionListener(this);
        exitButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == mulButton) {

            int a = Integer.parseInt(num1.getText());
            int b = Integer.parseInt(num2.getText());

            int multiplication = a * b;

            result.setText(String.valueOf(multiplication));
        }

        if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Multiplication();
    }
}