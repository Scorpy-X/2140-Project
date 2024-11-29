import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RoomsDisplayUI extends JFrame implements ActionListener {
    private final JButton btHome;
    private DefaultTableModel tableModel;
    private int accessLevel;
    private TaylorAdmin database;

    public RoomsDisplayUI(TaylorAdmin db, int accessLevel){
        setTitle("Room Display");
        this.database = db;
        this.accessLevel = accessLevel;
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        JPanel HEADERPANEL = new JPanel(new FlowLayout());
        HEADERPANEL.setBackground(new Color(40, 100, 220));
        HEADERPANEL.setPreferredSize(new Dimension(700, 40));
        add(HEADERPANEL, BorderLayout.NORTH);

        JPanel FOOTERPANEL = new JPanel(new FlowLayout());
        FOOTERPANEL.setBackground(new Color(40, 100, 220));
        FOOTERPANEL.setPreferredSize(new Dimension(700, 40));
        add(FOOTERPANEL, BorderLayout.SOUTH);

        JPanel DISPANEL = new JPanel();
        DISPANEL.setPreferredSize(new Dimension(800, 700));
        DISPANEL.setVisible(true);
        add(DISPANEL, BorderLayout.CENTER);
        getContentPane().add(DISPANEL, BorderLayout.CENTER);

        btHome = new JButton("Home");
        btHome.setFocusable(true);
        btHome.addActionListener(this);
        FOOTERPANEL.add(btHome);

        JLabel lbSort = new JLabel("Sort by: ");
        lbSort.setForeground(Color.white);
        HEADERPANEL.add(lbSort);
 
        String[] sortOptions = {"First Name (Ascending)", "First Name (Descending)", "Surname (Ascending)",
                "Surname (Descending)", "Room Number (Ascending)", "Room Number (Descending)",
                "Condition (Ascending)", "Condition (Descending)"};
        JComboBox<String> cmbSortOptions = new JComboBox<>(sortOptions);
        cmbSortOptions.setEditable(false);
        cmbSortOptions.addActionListener(this);
        HEADERPANEL.add(cmbSortOptions);

        String[] columnNames = {"Room Number", "Room Type", "Occupant's Name", "Bed Frame", "Mattress", "Closet", "Walls", "Window", "Chair", "Coffee Table", "Study Table", "Chest of Drawers"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable rTable = new JTable(tableModel);
        DISPANEL.add(rTable);
        JScrollPane scrollPane = new JScrollPane(rTable);
        add(scrollPane);

        loadRoomsTable(db.getAllRooms());

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addToTable(Room room) {
        String[] rDetails = new String[12];
        if (room.getRoomType() == "Single") {
            if (room.getOccupantLst().isEmpty()) {
                rDetails[0] = room.getRoomID();
                rDetails[1] = room.getRoomType();
                rDetails[2] = "";
                rDetails[3] = room.getBed().getState();
                rDetails[4] = room.getMattress().getState();
                rDetails[5] = room.getCloset().getState();
                rDetails[6] = room.getWall().getState();
                rDetails[7] = room.getWindow().getState();
                rDetails[8] = room.getEasyChair().getState();
                rDetails[9] = room.getCoffeeTable().getState();
                rDetails[10] = room.getStudyTable().getState();
                rDetails[11] = room.getChestOfDrawers().getState();
                tableModel.addRow(rDetails);
            }
            else {
                Occupant o = room.getOccupantLst().get(0);
                rDetails[0] = room.getRoomID();
                rDetails[1] = room.getRoomType();
                rDetails[2] = o.getFullName();
                rDetails[3] = room.getBed().getState();
                rDetails[4] = room.getMattress().getState();
                rDetails[5] = room.getCloset().getState();
                rDetails[6] = room.getWall().getState();
                rDetails[7] = room.getWindow().getState();
                rDetails[8] = room.getEasyChair().getState();
                rDetails[9] = room.getCoffeeTable().getState();
                rDetails[10] = room.getStudyTable().getState();
                rDetails[11] = room.getChestOfDrawers().getState();
                tableModel.addRow(rDetails);
            }
        }
        else if (room.getRoomType() == "Double") {
            String[] r2Details = new String[12];
            if (room.getOccupantLst().isEmpty()) {
                rDetails[0] = room.getRoomID();
                rDetails[1] = room.getRoomType();
                rDetails[2] = "";
                rDetails[3] = room.getBed().getState();
                rDetails[4] = room.getMattress().getState();
                rDetails[5] = room.getCloset().getState();
                rDetails[6] = room.getWall().getState();
                rDetails[7] = room.getWindow().getState();
                rDetails[8] = room.getEasyChair().getState();
                rDetails[9] = room.getCoffeeTable().getState();
                rDetails[10] = room.getStudyTable().getState();
                rDetails[11] = room.getChestOfDrawers().getState();
                tableModel.addRow(rDetails);

                r2Details[0] = room.getRoomID();
                r2Details[1] = room.getRoomType();
                r2Details[2] = "";
                r2Details[3] = room.getBed2().getState();
                r2Details[4] = room.getMattress2().getState();
                r2Details[5] = room.getCloset2().getState();
                r2Details[6] = room.getWall2().getState();
                r2Details[7] = room.getWindow2().getState();
                r2Details[8] = room.getEasyChair2().getState();
                r2Details[9] = room.getCoffeeTable2().getState();
                r2Details[10] = room.getStudyTable2().getState();
                r2Details[11] = room.getChestOfDrawers2().getState();
                tableModel.addRow(r2Details);
            }
            else {
                Occupant o = room.getOccupantLst().get(0);
                rDetails[0] = room.getRoomID();
                rDetails[1] = room.getRoomType();
                rDetails[2] = o.getFullName();
                rDetails[3] = room.getBed().getState();
                rDetails[4] = room.getMattress().getState();
                rDetails[5] = room.getCloset().getState();
                rDetails[6] = room.getWall().getState();
                rDetails[7] = room.getWindow().getState();
                rDetails[8] = room.getEasyChair().getState();
                rDetails[9] = room.getCoffeeTable().getState();
                rDetails[10] = room.getStudyTable().getState();
                rDetails[11] = room.getChestOfDrawers().getState();
                tableModel.addRow(rDetails);

                r2Details[0] = room.getRoomID();
                r2Details[1] = room.getRoomType();
                r2Details[2] = o.getFullName();
                r2Details[3] = room.getBed2().getState();
                r2Details[4] = room.getMattress2().getState();
                r2Details[5] = room.getCloset2().getState();
                r2Details[6] = room.getWall2().getState();
                r2Details[7] = room.getWindow2().getState();
                r2Details[8] = room.getEasyChair2().getState();
                r2Details[9] = room.getCoffeeTable2().getState();
                r2Details[10] = room.getStudyTable2().getState();
                r2Details[11] = room.getChestOfDrawers2().getState();
                tableModel.addRow(r2Details);
            }
        }
    }

    public void loadRoomsTable(ArrayList<Room> rooms) {
        for (Room r:rooms) {
            addToTable(r);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btHome) {
            new MainMenuUI(database, accessLevel);
            dispose();
        }
    }
}
