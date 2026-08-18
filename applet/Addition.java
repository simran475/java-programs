import javax.swing.*;

public class Addition {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Addition");

        JLabel label1 = new JLabel("First Number:");
        JTextField field1 = new JTextField(10);

        JLabel label2 = new JLabel("Second Number:");
        JTextField field2 = new JTextField(10);

        JLabel resultLabel = new JLabel("Result:");
        JTextField result = new JTextField(10);

        JButton add = new JButton("Add");

        frame.setLayout(new java.awt.FlowLayout());

        frame.add(label1);
        frame.add(field1);

        frame.add(label2);
        frame.add(field2);

        frame.add(add);

        frame.add(resultLabel);
        frame.add(result);

        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}