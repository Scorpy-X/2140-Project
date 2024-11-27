import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomDisplayUI extends JFrame implements ActionListener {
    private JPanel disPanel;
    private JButton btHome, btSortRNum, btSortBlock, btSortCondition;
    private DefaultTableModel tableModel;


    //should take a room as a paramater for display
    public RoomDisplayUI(){
        setTitle("Room Display");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        JPanel HEADERPANEL = new JPanel(new FlowLayout());
        HEADERPANEL.setPreferredSize(new Dimension(700, 40));
        add(HEADERPANEL, BorderLayout.NORTH);

        JPanel FOOTERPANEL = new JPanel(new FlowLayout());
        FOOTERPANEL.setPreferredSize(new Dimension(700, 40));
        add(FOOTERPANEL, BorderLayout.SOUTH);

        disPanel = new JPanel();
        disPanel.setVisible(true);
        disPanel.setPreferredSize(new Dimension(800, 700));
        add(disPanel, BorderLayout.CENTER);

        String[] columnNames = {"Room Number", "Occupant"};

        btHome = new JButton("Home");
        btHome.setFocusable(false);
        btHome.addActionListener(this);
        HEADERPANEL.add(btHome);

        btSortRNum = new JButton("Sort by Room Number");
        btSortRNum.setFocusable(true);
        btSortRNum.addActionListener(this);

        btSortBlock = new JButton("Sort by Block");
        btSortBlock.setFocusable(true);
        btSortBlock.addActionListener(this);

        btSortCondition = new JButton("Sort by Furniture Condition");
        btSortCondition.setFocusable(true);
        btSortCondition.addActionListener(this);

        getContentPane().add(HEADERPANEL, BorderLayout.NORTH);
        getContentPane().add(disPanel, BorderLayout.CENTER);
        getContentPane().add(FOOTERPANEL, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String [] args) {
        new RoomDisplayUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btHome) {

        } else if (e.getSource() == btSortBlock) {

        } else if (e.getSource() == btSortCondition) {

        } else if (e.getSource() == btSortRNum) {

        }
    }
}
