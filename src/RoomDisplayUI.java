import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RoomDisplayUI extends JFrame implements ActionListener {
    private final JButton btHome;
    private DefaultTableModel tableModel;


    //should take a room as a paramater for display
    public RoomDisplayUI(){
        setTitle("Room Display");
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

        JPanel disPanel = new JPanel();
        disPanel.setVisible(true);
        disPanel.setPreferredSize(new Dimension(800, 700));
        add(disPanel, BorderLayout.CENTER);

        String[] columnNames = {"Room Number", "Occupant"};

        btHome = new JButton("Home");
        btHome.setFocusable(true);
        btHome.addActionListener(this);
        HEADERPANEL.add(btHome);

        JLabel lbSort = new JLabel("Sort by: ");
        lbSort.setForeground(Color.white);
        HEADERPANEL.add(lbSort);

        String[] sortOptions = {"Christian Name (Ascending)", "Christian Name (Descending)", "Surname (Ascending)",
                "Surname (Descending)", "Room Number (Ascending)", "Room Number (Descending)",
                "Condition (Ascending)", "Condition (Descending)", "Block (Ascending)", "Block (Descending)"};
        JComboBox cmbSortOptions = new JComboBox(sortOptions);
        cmbSortOptions.setEditable(false);
        cmbSortOptions.addActionListener(this);
        HEADERPANEL.add(cmbSortOptions);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        getContentPane().add(HEADERPANEL, BorderLayout.NORTH);
        getContentPane().add(disPanel, BorderLayout.CENTER);
        getContentPane().add(FOOTERPANEL, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btHome) {
            System.out.println("Home pressed");
        }
    }

    public static void main(String [] args) {
        new RoomDisplayUI();
    }
}


