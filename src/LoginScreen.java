import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginScreen() {
        setTitle("Login - Room Inventory Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        usernameField.setMaximumSize(new Dimension(650, 25));

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(650, 25));

        JButton loginButton = new JButton("Login");
        loginButton.setMaximumSize(new Dimension(100, 30));
        //loginButton.setMaximumSize(new Dimension(200, 30));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        panel.add(usernameLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(usernameField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(passwordLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(passwordField);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(loginButton);

        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                dispose();
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}
