import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainScreenToLogin {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainScreen();
        });
    }
}

class MainScreen extends JFrame {

    private JLabel imageLabel;
    private Image originalImage;
    

    public MainScreen() {
      
        setTitle("RIMS - Room Inventory Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String imagePath = "rims.png";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        originalImage = imageIcon.getImage();

        
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);

    
        JLabel textLabel = new JLabel("Press any key to continue...", SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 16));

    
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(imageLabel, BorderLayout.CENTER);
        mainPanel.add(textLabel, BorderLayout.SOUTH);

        
        add(mainPanel);

        
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                resizeImage();
            }
        });

    
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                //new LoginScreen();
                dispose();
            }
        });
        SwingUtilities.invokeLater(this::resizeImage);
        setVisible(true);
    }

    private void resizeImage() {
        
        int width = Math.max(getContentPane().getWidth(), 1); 
        int height = Math.max(getContentPane().getHeight()  -50, 1); 
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
    }
}