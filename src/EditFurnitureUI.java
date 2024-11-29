import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EditFurnitureUI extends JFrame {
	public static final List<String> SingleRoomFurniture_LIST = List.of("Easy Chair","Bed","Mattress","Closet","Coffee Table","Study Table","Chest of Draws","Wall","Window");
	public static final List<String> DoubleRoomFurniture_LIST = List.of("Easy Chair","Bed","Mattress","Closet","Coffee Table","Study Table","Chest of Draws","Wall","Window","Easy Chair2","Bed2","Mattrass2","Closet2","Coffee Table2","Study Table2","Chest of Draws2","Wall2","Window2");
	private final String[] options = {"Excellent", "Fair", "Poor","None"};
	private JTextField room_idF;
	private JComboBox easyChairF;
    private JComboBox bedF;					
    private JComboBox mattressF;
    private JComboBox closetF;
    private JComboBox coffeeTableF;
    private JComboBox studyTableF;
    private JComboBox chestOfDrawersF;
    private JComboBox wallF;
    private JComboBox windowF;

    private JComboBox easyChair2F;              
    private JComboBox bed2F;
    private JComboBox mattress2F;
    private JComboBox closet2F;
    private JComboBox coffeeTable2F;
    private JComboBox studyTable2F;
    private JComboBox chestOfDrawers2F;
    private JComboBox wall2F;
    private JComboBox window2F;

	public void getRoomIDUI(TaylorAdmin th){
		setTitle("Room Number of Furniture to be edited");
		setSize(380, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3, 2, 10, 10));
		JLabel room_idLabel = new JLabel("Room ID:");
		room_idF = new JTextField();
		JButton submitButton = new JButton("Submit"); 
		add(room_idLabel);
		add(room_idF);
		add(submitButton); 
		submitButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				try {
				String room_id = room_idF.getText();
				Room r = th.findByRoomIdNum(room_id);
				if(r==null) {
					JOptionPane.showMessageDialog(null, "Please enter a valid room number.");
				}else{
					dispose();
					remove(room_idLabel);
					remove(room_idF);
					remove(submitButton);
					FurnitureFormUI(r,th); 
				}
				
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Please enter an integer for ID Number.");
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				
				 } });
		setVisible(true); 
	}

	public void FurnitureFormUI(Room r, TaylorAdmin th) {
		setTitle("Edit Furniture Form");
		
		setSize(600,700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		JLabel easyChairFLabel = new JLabel("Easy Chair:");
		easyChairF = new JComboBox<>(options);
		JLabel bedFLabel = new JLabel("Bed:");
		bedF = new JComboBox<>(options);
		JLabel mattressFLabel = new JLabel("Mattress:");
		mattressF = new JComboBox<>(options);
		JLabel closetFLabel = new JLabel("Closet:");
		closetF = new JComboBox<>(options);
		JLabel coffeeTableFLabel = new JLabel("Coffee Table:");
		coffeeTableF = new JComboBox<>(options);
		JLabel studyTableFLabel = new JLabel("Study Table:");
		studyTableF = new JComboBox<>(options);
		JLabel chestOfDrawersFLabel = new JLabel("Chest of Drawers:");
		chestOfDrawersF = new JComboBox<>(options);
		JLabel wallFLabel = new JLabel("Wall:");
		wallF = new JComboBox<>(options);
		JLabel windowFLabel = new JLabel("Window:");
		windowF = new JComboBox<>(options);
		
		
		JLabel easyChair2FLabel = new JLabel("Easy Chair 2:");
		easyChair2F = new JComboBox<>(options);
		JLabel bed2FLabel = new JLabel("Bed 2:");
		bed2F = new JComboBox<>(options);
		JLabel mattress2FLabel = new JLabel("Mattress 2:");
		mattress2F = new JComboBox<>(options);
		JLabel closet2FLabel = new JLabel("Closet 2:");
		closet2F = new JComboBox<>(options);
		JLabel coffeeTable2FLabel = new JLabel("Coffee Table 2:");
		coffeeTable2F = new JComboBox<>(options);
		JLabel studyTable2FLabel = new JLabel("Study Table 2:");
		studyTable2F = new JComboBox<>(options);
		JLabel chestOfDrawers2FLabel = new JLabel("Chest of Drawers 2:");
		chestOfDrawers2F = new JComboBox<>(options);
		JLabel wall2FLabel = new JLabel("Wall 2:");
		wall2F = new JComboBox<>(options);
		JLabel window2FLabel = new JLabel("Window 2:");
		window2F = new JComboBox<>(options);
		JButton submitButton = new JButton("Submit"); 
		
		if(r.getRoomType().equals("Single")) {
			setLayout(new GridLayout(10, 2, 10, 10)); 
			easyChairF.setSelectedItem(r.getEasyChair().getState()); 
			bedF.setSelectedItem(r.getBed().getState()); 
			mattressF.setSelectedItem(r.getMattress().getState()); 
			closetF.setSelectedItem(r.getCloset().getState()); 
			coffeeTableF.setSelectedItem(r.getCoffeeTable().getState()); 
			studyTableF.setSelectedItem(r.getStudyTable().getState()); 
			chestOfDrawersF.setSelectedItem(r.getChestOfDrawers().getState()); 
			wallF.setSelectedItem(r.getWall().getState()); 
			windowF.setSelectedItem(r.getWindow().getState()); 
		}else {
			setLayout(new GridLayout(20, 2, 10, 10)); 
			easyChairF.setSelectedItem(r.getEasyChair().getState()); 
			bedF.setSelectedItem(r.getBed().getState()); 
			mattressF.setSelectedItem(r.getMattress().getState()); 
			closetF.setSelectedItem(r.getCloset().getState()); 
			coffeeTableF.setSelectedItem(r.getCoffeeTable().getState()); 
			studyTableF.setSelectedItem(r.getStudyTable().getState()); 
			chestOfDrawersF.setSelectedItem(r.getChestOfDrawers().getState()); 
			wallF.setSelectedItem(r.getWall().getState()); 
			windowF.setSelectedItem(r.getWindow().getState()); 

			easyChair2F.setSelectedItem(r.getEasyChair2().getState()); 
			bed2F.setSelectedItem(r.getBed2().getState()); 
			mattress2F.setSelectedItem(r.getMattress2().getState()); 
			closet2F.setSelectedItem(r.getCloset2().getState()); 
			coffeeTable2F.setSelectedItem(r.getCoffeeTable2().getState()); 
			studyTable2F.setSelectedItem(r.getStudyTable2().getState()); 
			chestOfDrawers2F.setSelectedItem(r.getChestOfDrawers2().getState()); 
			wall2F.setSelectedItem(r.getWall2().getState()); 
			window2F.setSelectedItem(r.getWindow2().getState());

		}
		
		
		add(easyChairFLabel);
		add(easyChairF);
		add(bedFLabel);
		add(bedF);
		add(mattressFLabel);
		add(mattressF);
		add(closetFLabel);
		add(closetF);
		add(coffeeTableFLabel);
		add(coffeeTableF);
		add(studyTableFLabel);
		add(studyTableF);
		add(chestOfDrawersFLabel);
		add(chestOfDrawersF);
		add(wallFLabel);
		add(wallF);
		add(windowFLabel);
		add(windowF);
		if(r.getRoomType().equals("Double")) {
			add(easyChair2FLabel);
			add(easyChair2F);
			add(bed2FLabel);
			add(bed2F);
			add(mattress2FLabel);
			add(mattress2F);
			add(closet2FLabel);
			add(closet2F);
			add(coffeeTable2FLabel);
			add(coffeeTable2F);
			add(studyTable2FLabel);
			add(studyTable2F);
			add(chestOfDrawers2FLabel);
			add(chestOfDrawers2F);
			add(wall2FLabel);
			add(wall2F);
			add(window2FLabel);
			add(window2F);
		}
		add(submitButton); 
		submitButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				try {
					r.getEasyChair().setState((String) easyChairF.getSelectedItem());
					r.getBed().setState((String) bedF.getSelectedItem());
					r.getMattress().setState((String) mattressF.getSelectedItem());
					r.getCloset().setState((String) closetF.getSelectedItem());
					r.getCoffeeTable().setState((String) coffeeTableF.getSelectedItem());
					r.getStudyTable().setState((String) studyTableF.getSelectedItem());
					r.getChestOfDrawers().setState((String) chestOfDrawersF.getSelectedItem());
					r.getWall().setState((String) wallF.getSelectedItem());
					r.getWindow().setState((String) windowF.getSelectedItem());
					
					if(r.getRoomType().equals("Double")) {
						r.getEasyChair2().setState((String) easyChair2F.getSelectedItem());
						r.getBed2().setState((String) bed2F.getSelectedItem());
						r.getMattress2().setState((String) mattress2F.getSelectedItem());
						r.getCloset2().setState((String) closet2F.getSelectedItem());
						r.getCoffeeTable2().setState((String) coffeeTable2F.getSelectedItem());
						r.getStudyTable2().setState((String) studyTable2F.getSelectedItem());
						r.getChestOfDrawers2().setState((String) chestOfDrawers2F.getSelectedItem());
						r.getWall2().setState((String) wall2F.getSelectedItem());
						r.getWindow2().setState((String) window2F.getSelectedItem());
					}
					JOptionPane.showMessageDialog(null, "Furniture Edited Successfully");
					dispose();
                	//new MainMenuUI();
				
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				
				 } });
		setVisible(true); 
	}

	public static void main(String[] args) { 
		new EditFurnitureUI().getRoomIDUI(new TaylorAdmin()); 
	}
}
		