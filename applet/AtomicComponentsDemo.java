import javax.swing.*;
import java.awt.*;

public class AtomicComponentsDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Atomic Components Demo");

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));

        // Background colour
        frame.getContentPane().setBackground(new Color(230, 240, 255));

        // Title
        JLabel title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(40, 70, 150));
        frame.add(title);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(new Color(30, 30, 100));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(nameLabel);

        JTextField name = new JTextField(15);
        name.setBackground(Color.WHITE);
        frame.add(name);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(new Color(30, 30, 100));
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(passwordLabel);

        JPasswordField password = new JPasswordField(15);
        password.setBackground(Color.WHITE);
        frame.add(password);

        // Checkbox
        JCheckBox subscribe = new JCheckBox("Subscribe to newsletter");
        subscribe.setBackground(new Color(230, 240, 255));
        subscribe.setForeground(new Color(20, 100, 70));
        frame.add(subscribe);

        // Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Arial", Font.BOLD, 14));
        genderLabel.setForeground(new Color(30, 30, 100));
        frame.add(genderLabel);

        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");

        male.setBackground(new Color(230, 240, 255));
        female.setBackground(new Color(230, 240, 255));

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        frame.add(male);
        frame.add(female);

        // Country
        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setFont(new Font("Arial", Font.BOLD, 14));
        countryLabel.setForeground(new Color(30, 30, 100));
        frame.add(countryLabel);

        JComboBox<String> country =
                new JComboBox<>(new String[]{"India", "USA", "UK", "Nepal"});

        frame.add(country);

        // Volume
        JLabel volumeLabel = new JLabel("Volume:");
        volumeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        volumeLabel.setForeground(new Color(30, 30, 100));
        frame.add(volumeLabel);

        JSlider volume = new JSlider(0, 100, 50);
        volume.setBackground(new Color(230, 240, 255));
        frame.add(volume);

        // Age
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        ageLabel.setForeground(new Color(30, 30, 100));
        frame.add(ageLabel);

        JSpinner age =
                new JSpinner(new SpinnerNumberModel(18, 1, 100, 1));

        frame.add(age);

        // Submit button
        JButton submit = new JButton("Submit");
        submit.setBackground(new Color(70, 130, 220));
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Arial", Font.BOLD, 15));

        submit.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        frame,
                        "Form Submitted Successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                )
        );

        frame.add(submit);

        // Show window
        frame.setVisible(true);
    }
}