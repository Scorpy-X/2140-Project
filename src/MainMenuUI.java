import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuUI extends JFrame implements ActionListener {
    private JButton btLogout, btDisplayRooms, btDisplayOccupants, btAddOccupant, btEditOccupant, btDeleteOccupant, btEditFurniture, btGenReport;
    private int accessLevel;
    private TaylorAdmin th;

    //Default constructor
    public MainMenuUI() {
    }

    public MainMenuUI(TaylorAdmin db, int accessLevel) {
        this.accessLevel = accessLevel;
        this.th = db;
        setTitle("RIMS - Main Menu");
        setBackground(Color.black);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout(10, 20));

        JPanel HEADERPANEL = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 8));
        HEADERPANEL.setBackground(new Color(40, 100, 200));
        HEADERPANEL.setPreferredSize(new Dimension(700, 40));
        add(HEADERPANEL, BorderLayout.NORTH);

        JPanel DISPANEL = new JPanel(new GridLayout(7, 1));
        DISPANEL.setBackground(Color.white);
        DISPANEL.setVisible(true);
        DISPANEL.setPreferredSize(new Dimension(400, 700));
        add(DISPANEL, BorderLayout.CENTER);

        JPanel EASTPANEL = new JPanel();
        EASTPANEL.setVisible(true);
        EASTPANEL.setPreferredSize(new Dimension(150, 700));
        add(EASTPANEL, BorderLayout.EAST);

        JPanel WESTPANEL = new JPanel();
        WESTPANEL.setVisible(true);
        WESTPANEL.setPreferredSize(new Dimension(150, 700));
        add(WESTPANEL, BorderLayout.WEST);

        JPanel FOOTERPANEL = new JPanel(new FlowLayout(FlowLayout.TRAILING, 20, 8));
        FOOTERPANEL.setBackground(new Color(40, 100, 200));
        FOOTERPANEL.setPreferredSize(new Dimension(700, 40));
        add(FOOTERPANEL, BorderLayout.SOUTH);

        JLabel lbHome = new JLabel("Taylor Hall Room Management Home");
        lbHome.setFont(new Font("Arial", Font.BOLD, 20));
        lbHome.setForeground(Color.white);
        HEADERPANEL.add(lbHome);

        btLogout = new JButton("Logout");
        btLogout.addActionListener(this);
        btLogout.setFocusable(false);
        btLogout.setPreferredSize(new Dimension(80, 20));
        btLogout.setForeground(Color.black);
        btLogout.setBackground(Color.white);
        FOOTERPANEL.add(btLogout);

        btDisplayRooms = new JButton("Display Rooms");
        btDisplayRooms.addActionListener(this);
        btDisplayRooms.setFocusable(false);
        btDisplayRooms.setPreferredSize(new Dimension(40, 20));
        btDisplayRooms.setForeground(Color.white);
        btDisplayRooms.setBackground(new Color(40, 100, 220));
        btDisplayRooms.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
        DISPANEL.add(btDisplayRooms);

        btDisplayOccupants = new JButton("Display Occupants");
        btDisplayOccupants.addActionListener(this);
        btDisplayOccupants.setFocusable(false);
        btDisplayOccupants.setPreferredSize(new Dimension(40, 20));
        btDisplayOccupants.setForeground(Color.white);
        btDisplayOccupants.setBackground(new Color(40, 100, 220));
        btDisplayOccupants.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
        DISPANEL.add(btDisplayOccupants);

        btAddOccupant = new JButton("Add Occupant");
        btAddOccupant.addActionListener(this);
        btAddOccupant.setFocusable(false);
        btAddOccupant.setPreferredSize(new Dimension(40, 20));
        btAddOccupant.setForeground(Color.white);
        btAddOccupant.setBackground(new Color(40, 100, 220));
        btAddOccupant.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
        DISPANEL.add(btAddOccupant);

        btEditOccupant = new JButton("Edit Occupant");
        btEditOccupant.addActionListener(this);
        btEditOccupant.setFocusable(false);
        btEditOccupant.setPreferredSize(new Dimension(40, 20));
        btEditOccupant.setForeground(Color.white);
        btEditOccupant.setBackground(new Color(40, 100, 220));
        btEditOccupant.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
        DISPANEL.add(btEditOccupant);

        btDeleteOccupant = new JButton("Delete Occupant");
        btDeleteOccupant.addActionListener(this);
        btDeleteOccupant.setFocusable(false);
        btDeleteOccupant.setPreferredSize(new Dimension(40, 20));
        btDeleteOccupant.setForeground(Color.white);
        btDeleteOccupant.setBackground(new Color(40, 100, 220));
        btDeleteOccupant.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
        DISPANEL.add(btDeleteOccupant);

        btEditFurniture = new JButton("Edit Furniture");
        btEditFurniture.addActionListener(this);
        btEditFurniture.setFocusable(false);
        btEditFurniture.setPreferredSize(new Dimension(40, 20));
        btEditFurniture.setForeground(Color.white);
        btEditFurniture.setBackground(new Color(40, 100, 220));
        btEditFurniture.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
        DISPANEL.add(btEditFurniture);

        btGenReport = new JButton("Generate Report");
        btGenReport.addActionListener(this);
        btGenReport.setFocusable(false);
        btGenReport.setPreferredSize(new Dimension(40, 20));
        btGenReport.setForeground(Color.white);
        btGenReport.setBackground(new Color(40, 100, 220));
        btGenReport.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
        DISPANEL.add(btGenReport);

        if (accessLevel == 1) {
            btEditFurniture.setEnabled(true);
            btEditFurniture.setText(btEditFurniture.getText() + " (Restricted)");
            btAddOccupant.setEnabled(false);
            btAddOccupant.setText(btAddOccupant.getText() + " (Restricted)");
            btDeleteOccupant.setEnabled(false);
            btDeleteOccupant.setText(btDeleteOccupant.getText() + " (Restricted)");
            btDisplayOccupants.setEnabled(false);
            btDisplayOccupants.setText(btDisplayOccupants.getText() + " (Restricted)");
            btDisplayRooms.setEnabled(false);
            btDisplayRooms.setText(btDisplayRooms.getText() + " (Restricted)");
            btEditOccupant.setEnabled(false);
            btEditOccupant.setText(btEditOccupant.getText() + " (Restricted)");
            btGenReport.setEnabled(false);
            btGenReport.setText(btGenReport.getText() + " (Restricted)");
        }
        else if (accessLevel == 2) {
            btEditFurniture.setEnabled(true);
            btAddOccupant.setEnabled(true);
            btDeleteOccupant.setEnabled(true);
            btDisplayOccupants.setEnabled(true);
            btDisplayRooms.setEnabled(true);
            btEditOccupant.setEnabled(true);
            btGenReport.setEnabled(true);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btLogout) {
            th.saveAllData();
            new LoginScreenUI(th);
            dispose();
        }
        else if (e.getSource() == btDisplayRooms) {
            new RoomsDisplayUI(th, accessLevel);
            dispose();
        }
        else if (e.getSource() == btDisplayOccupants) {
            System.out.println("Display occupant pressed");
        }
        else if (e.getSource() == btAddOccupant) {
            new AddOccupantUI().OccupantFormUI(th, accessLevel);
        }
        else if (e.getSource() == btEditOccupant) {
            new EditOccupantUI().getOccupantIDUI(th); 
        }
        else if (e.getSource() == btDeleteOccupant) {
            new DeleteOccupantUI().getOccupantIDUI(th, 1);
        }
        else if (e.getSource() == btEditFurniture) {
            new EditFurnitureUI().getRoomIDUI(th);
        }
        else if (e.getSource() == btGenReport) {
            System.out.println("Generate report pressed");
        }
    }
}
