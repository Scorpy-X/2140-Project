import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
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

        btHome = new JButton("Home");
        btHome.setFocusable(true);
        btHome.addActionListener(this);
        HEADERPANEL.add(btHome);

        JLabel lbSort = new JLabel("Sort by: ");
        lbSort.setForeground(Color.white);
        HEADERPANEL.add(lbSort);
 
        String[] sortOptions = {"First Name (Ascending)", "First Name (Descending)", "Surname (Ascending)",
                "Surname (Descending)", "Room Number (Ascending)", "Room Number (Descending)",
                "Condition (Ascending)", "Condition (Descending)", "Block (Ascending)", "Block (Descending)"};
        JComboBox cmbSortOptions = new JComboBox(sortOptions);
        cmbSortOptions.setEditable(false);
        cmbSortOptions.addActionListener(this);
        HEADERPANEL.add(cmbSortOptions);

        String[] columnNames = {"Room Number", "Block", "Room Type", "Occupant's First Name", "Occupant's Surname"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable rTable = new JTable(tableModel);
        disPanel.add(rTable);
        JScrollPane scrollPane = new JScrollPane(rTable);
        add(scrollPane);
        ArrayList<Room> allRooms = new ArrayList<>();
        for (Block b:TaylorAdmin.getBlocks()) {
            allRooms.addAll(b.getRooms());
        }
        loadRoomsTable(allRooms);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        getContentPane().add(HEADERPANEL, BorderLayout.NORTH);
        getContentPane().add(disPanel, BorderLayout.CENTER);
        getContentPane().add(FOOTERPANEL, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public RoomDisplayUI(Block block){
        setTitle("Room Display - Block");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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

        btHome = new JButton("Home");
        btHome.setFocusable(true);
        btHome.addActionListener(this);
        HEADERPANEL.add(btHome);

        JLabel lbSort = new JLabel("Sort by: ");
        lbSort.setForeground(Color.white);
        HEADERPANEL.add(lbSort);

        String[] sortOptions = {"First Name (Ascending)", "First Name (Descending)", "Surname (Ascending)",
                "Surname (Descending)", "Room Number (Ascending)", "Room Number (Descending)",
                "Condition (Ascending)", "Condition (Descending)", "Block (Ascending)", "Block (Descending)"};
        JComboBox cmbSortOptions = new JComboBox(sortOptions);
        cmbSortOptions.setEditable(false);
        cmbSortOptions.addActionListener(this);
        HEADERPANEL.add(cmbSortOptions);

        String[] columnNames = {"Room Number", "Block", "Room Type", "Occupant's First Name", "Occupant's Surname"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable rTable = new JTable(tableModel);
        disPanel.add(rTable);
        JScrollPane scrollPane = new JScrollPane(rTable);
        add(scrollPane);
        ArrayList<Room> allRooms = new ArrayList<>();
        for (Block b:TaylorAdmin.getBlocks()) {
            allRooms.addAll(b.getRooms());
        }
        loadRoomsTable(allRooms);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        getContentPane().add(HEADERPANEL, BorderLayout.NORTH);
        getContentPane().add(disPanel, BorderLayout.CENTER);
        getContentPane().add(FOOTERPANEL, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addToTable(Room room) {
        if (room.getOccupantLst().isEmpty()) {
            String roomNum = room.getRoomID();
            String blockNm = String.valueOf(room.getBlock());
            String roomType = room.getRoomType();

            String[] rDetails = new String[5];
            rDetails[0] = roomNum;
            rDetails[1] = blockNm;
            rDetails[2] = roomType;
            rDetails[3] = "";
            rDetails[4] = "";
        }
        else {
            for (Occupant o:room.getOccupantLst()) {
                String occupantFName = o.getfName();
                String occupantLName = o.getlName();
                String roomNum = room.getRoomID();
                String blockNm = String.valueOf(room.getBlock());
                String roomType = room.getRoomType();

                String[] rDetails = new String[5];
                rDetails[0] = roomNum;
                rDetails[1] = blockNm;
                rDetails[2] = roomType;
                rDetails[3] = occupantFName;
                rDetails[4] = occupantLName;

                tableModel.addRow(rDetails);
            }
        }

    }

    private void loadRoomsTable(ArrayList<Room> rooms) {
        for (Room r:rooms) {
            addToTable(r);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btHome) {
            System.out.println("Home pressed");
        }
    }

    public static void main(String [] args) {
        new TaylorAdmin(DataManager.loadData());
        new RoomDisplayUI();
    }
}


