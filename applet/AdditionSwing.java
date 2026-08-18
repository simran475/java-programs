import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdditionSwing implements ActionListener {

    JFrame frame;
    JTextField num1, num2, result;
    JButton add, clear;

    AdditionSwing() {

        frame = new JFrame("Addition");

        num1 = new JTextField(10);
        num2 = new JTextField(10);
        result = new JTextField(10);

        add = new JButton("Add");
        clear = new JButton("Clear");

        frame.setLayout(new FlowLayout());

        frame.add(new JLabel("Number 1:"));
        frame.add(num1);

        frame.add(new JLabel("Number 2:"));
        frame.add(num2);

        frame.add(add);
        frame.add(clear);

        frame.add(new JLabel("Result:"));
        frame.add(result);

        add.addActionListener(this);
        clear.addActionListener(this);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {

            int a = Integer.parseInt(num1.getText());
            int b = Integer.parseInt(num2.getText());

            result.setText(String.valueOf(a + b));
        }

        if (e.getSource() == clear) {

            num1.setText("");
            num2.setText("");
            result.setText("");
        }
    }

    public static void main(String[] args) {
        new AdditionSwing();
    }
}