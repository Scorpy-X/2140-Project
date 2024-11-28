import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuUI extends JFrame implements ActionListener {
    //Attributes here

    //Default constructor
    public MainMenuUI() {
    }

    public MainMenuUI(int accessLevel) {
        setTitle("RIMS - Main Menu");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        JPanel HEADERPANEL = new JPanel(new FlowLayout());
        HEADERPANEL.setBackground(Color.black);
        HEADERPANEL.setPreferredSize(new Dimension(700, 40));
        add(HEADERPANEL, BorderLayout.NORTH);

        JPanel FOOTERPANEL = new JPanel(new FlowLayout());
        FOOTERPANEL.setBackground(Color.black);
        FOOTERPANEL.setPreferredSize(new Dimension(700, 40));
        add(FOOTERPANEL, BorderLayout.SOUTH);

        JPanel disPanel = new JPanel(new BorderLayout());
        disPanel.setVisible(true);
        disPanel.setPreferredSize(new Dimension(800, 700));
        add(disPanel, BorderLayout.CENTER);

        if (accessLevel == 0) {
            System.out.println("Access Level 1");
        }
        else if (accessLevel == 1) {
            System.out.println("Access Level 2");
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {


    }

    public static void main(String[] args) {
        new MainMenuUI(1);
    }
}
