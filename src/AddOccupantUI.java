import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOccupantUI extends JFrame {
	private JTextField room_idF;
	private JTextField fNameF;
	private JTextField lNameF;
	private JTextField idNumF;
	private JTextField phoneNumberF;
	private JTextField emailF;
	public void OccupantFormUI(TaylorAdmin th) {
		setTitle("Add Occupant Form");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(7, 3, 10, 10)); 
		JLabel room_idLabel = new JLabel("Room ID:");
		room_idF = new JTextField();
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
		add(room_idLabel);
		add(room_idF);
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
				}else if(!th.isValidIdNumber(idNum)) {
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
		new AddOccupantUI().OccupantFormUI(new TaylorAdmin()); 
	}
		
	
}
