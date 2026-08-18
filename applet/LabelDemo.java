import javax.swing.*;
import java.awt.*;

public class LabelDemo {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Label Example");

        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("name:");
        frame.add(label);

        frame.setVisible(true);
    }
}