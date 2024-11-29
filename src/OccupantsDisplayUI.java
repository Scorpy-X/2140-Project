import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OccupantsDisplayUI extends JFrame implements ActionListener{
    private TaylorAdmin database;
    private final JButton btHome;
    JComboBox<String> cmbSortOptions;
    private DefaultTableModel tableModel;
    private int accessLevel;

    public OccupantsDisplayUI(TaylorAdmin db, int accessLevel) {
        this.database = db;
        this.accessLevel = accessLevel;
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        //////////////////////////////////////////////////////////////
        
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
 
        String[] sortOptions = {" ", "First Name (Ascending)", "First Name (Descending)", "Surname (Ascending)",
                "Surname (Descending)"};
        cmbSortOptions = new JComboBox<>(sortOptions);
        cmbSortOptions.setEditable(false);
        cmbSortOptions.addActionListener(this);
        HEADERPANEL.add(cmbSortOptions);

        String[] columnNames = {"First Name", "Last Name", "ID Number", "Phone", "E-Mail Address"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable rTable = new JTable(tableModel);
        DISPANEL.add(rTable);
        JScrollPane scrollPane = new JScrollPane(rTable);
        add(scrollPane);

        loadOccupantsTable(db.getAllOccupants());

        /////////////////////////////////////////////////////////////
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addToTable(Occupant o) {
        String[] oDetails = new String[5];
        oDetails[0] = o.getfName();
        oDetails[1] = o.getlName();
        oDetails[2] = o.getIdNumstr();
        oDetails[3] = o.getPhoneNumber();
        oDetails[4] = o.getEmail();
        tableModel.addRow(oDetails);
    }

    public void loadOccupantsTable(ArrayList<Occupant> occupants) {
        for (Occupant o:occupants) {
            addToTable(o);
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btHome) {
            new MainMenuUI(database, accessLevel);
            dispose();
        }
        else if (cmbSortOptions.getSelectedIndex() == 1) {
            ArrayList<Occupant> localOccupants = new ArrayList<>();
            localOccupants.addAll(database.getAllOccupants());
            Collections.sort(localOccupants, new SortbyFirstNameAsc());
            tableModel.setRowCount(0);
            loadOccupantsTable(localOccupants);
        }
        else if (cmbSortOptions.getSelectedIndex() == 2) {
            ArrayList<Occupant> localOccupants = new ArrayList<>();
            localOccupants.addAll(database.getAllOccupants());
            Collections.sort(localOccupants, new SortbyFirstNameDsc());
            tableModel.setRowCount(0);
            loadOccupantsTable(localOccupants);
        }
        else if (cmbSortOptions.getSelectedIndex() == 3) {
            ArrayList<Occupant> localOccupants = new ArrayList<>();
            localOccupants.addAll(database.getAllOccupants());
            Collections.sort(localOccupants, new SortbyLastNameAsc());
            tableModel.setRowCount(0);
            loadOccupantsTable(localOccupants);
        }
        else if (cmbSortOptions.getSelectedIndex() == 4) {
            ArrayList<Occupant> localOccupants = new ArrayList<>();
            localOccupants.addAll(database.getAllOccupants());
            Collections.sort(localOccupants, new SortbyLastNameDsc());
            tableModel.setRowCount(0);
            loadOccupantsTable(localOccupants);
        }
    }
}
