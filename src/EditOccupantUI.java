import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditOccupantUI extends JFrame {
	private JTextField fNameF;
	private JTextField lNameF;
	private JTextField idNumF;
	private JTextField phoneNumberF;
	private JTextField emailF;
	public void getRoomIDUI(TaylorAdmin th){
		setTitle("ID Number of Student to be edited");
		setSize(380, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3, 2, 10, 10));
		JLabel idNumLabel = new JLabel("Student ID:");
		idNumF = new JTextField();
		JButton submitButton = new JButton("Submit"); 
		add(idNumLabel);
		add(idNumF);
		add(submitButton); 
		submitButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				try {
				int idNum = Integer.parseInt(idNumF.getText());
				if(!TaylorAdmin.isValidIdNumber(idNum)) {
					dispose();
					//EditOccupantUI.OccupantFormUI(TaylorAdmin.getOccupantwithid(idNum),th); 
				}else {
					JOptionPane.showMessageDialog(null, "There is no occupant with this id.");
				}
				
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Please enter an integer for ID Number.");
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				
				 } });
		setVisible(true); 
	}
	public void OccupantFormUI(Occupant o, TaylorAdmin th) {
		setTitle("Edit Occupant Form");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(6, 2, 10, 10)); 
		
		JLabel fNameLabel = new JLabel("First Name:");
		fNameF = new JTextField();
		JLabel lNameLabel = new JLabel("Last Name:");
		lNameF = new JTextField();
		JLabel idNumLabel = new JLabel("ID Number:");
		idNumF = new JTextField();
		JLabel phoneNumberLabel = new JLabel("Phone Number:");
		phoneNumberF = new JTextField();
		JLabel emailLabel = new JLabel("Email:");
		emailF = new JTextField();
		JButton submitButton = new JButton("Submit"); 
		add(fNameLabel);
		add(fNameF);
		add(lNameLabel);
		add(lNameF);
		add(idNumLabel); 
		add(idNumF);
		add(phoneNumberLabel);
		add(phoneNumberF);
		add(emailLabel);
		add(emailF);
		add(submitButton); 
		submitButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				try {
				String room_id = room_idF.getText();
				String fName = fNameF.getText(); 
				String lName = lNameF.getText(); 
				int idNum = Integer.parseInt(idNumF.getText());
				String phoneNumber = phoneNumberF.getText();
				String email = emailF.getText();
				Room r = th.findByRoomIdNum(room_id);
				if(r==null) {
					JOptionPane.showMessageDialog(null, "Please enter a valid room number.");
				}else if(r.isRoomFull()){
					JOptionPane.showMessageDialog(null, "Room is already at maximum occupancy");
				}else if(!TaylorAdmin.isValidIdNumber(idNum)) {
					JOptionPane.showMessageDialog(null, "Another Occupant has this ID number");
				}else {
					r.addOccupant(new Occupant(fName,lName,idNum,phoneNumber,email));
					JOptionPane.showMessageDialog(null, "Occupant Added Successfully");
					dispose();
                	//new MainMenuUI();
				}
				
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Please enter an integer for ID Number.");
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				
				 } });
		setVisible(true); 
	} 
	public static void main(String[] args) { 
		new EditOccupantUI().getRoomIDUI(new TaylorAdmin()); 
	}
		
	
}
