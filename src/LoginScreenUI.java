import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreenUI extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel errorLabel;
    private TaylorAdmin database;
    
    public LoginScreenUI(TaylorAdmin db) {
        this.database = db;
        setTitle("Login - Room Inventory Management System");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        usernameField.setMaximumSize(new Dimension(650, 25));
        usernameField.addActionListener(this);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(650, 25));
        passwordField.addActionListener(this);

        JButton loginButton = new JButton("Login");
        loginButton.setMaximumSize(new Dimension(100, 30));
        //loginButton.setMaximumSize(new Dimension(200, 30));
        
        errorLabel = new JLabel(" ");
        errorLabel.setForeground(Color.RED);
        errorLabel.setPreferredSize(new Dimension(650, 25));
        errorLabel.setMaximumSize(new Dimension(650, 25)); 
        errorLabel.setMinimumSize(new Dimension(650, 25));
        
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
        panel.add(errorLabel);
        
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                int validationResult = Login.validateLogin(username, password);
                if (validationResult == 0){ 
                	errorLabel.setText("Invalid username or password.");
                } else if(validationResult == 1){
                	dispose();
                	new MainMenuUI(database, 1);
                	
                } else if(validationResult == 2){
                	dispose();
                	new MainMenuUI(database, 2);
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == usernameField) {
            passwordField.requestFocusInWindow();
        }
        else if (e.getSource() == passwordField) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            int validationResult = Login.validateLogin(username, password);
            if (validationResult == 0){
            	errorLabel.setText("Invalid username or password.");
            }
            else if(validationResult == 1){
            	dispose();
            	new MainMenuUI(database, 1);	
            } else if(validationResult == 2){
                dispose();
            	new MainMenuUI(database, 2);
            };
        }
    }
}
