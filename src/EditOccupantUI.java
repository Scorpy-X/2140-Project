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
	public void getOccupantIDUI(TaylorAdmin th){
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
					remove(idNumLabel);
					remove(idNumF);
					remove(submitButton);
					OccupantFormUI(th.getOccupant(idNum),th); 
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
		setLayout(new GridLayout(7, 2, 10, 10)); 
		
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
		fNameF.setText(o.getfName());
		lNameF.setText(o.getlName());
		idNumF.setText(o.getIdNumstr());
		phoneNumberF.setText(o.getPhoneNumber());
		emailF.setText(o.getEmail());
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
				String fName = fNameF.getText(); 
				String lName = lNameF.getText(); 
				int idNum = Integer.parseInt(idNumF.getText());
				String phoneNumber = phoneNumberF.getText();
				String email = emailF.getText();
				if(!TaylorAdmin.isValidIdNumber(idNum)&&idNum!=o.getIdNum()) {
					JOptionPane.showMessageDialog(null, "Another Occupant has this ID number");
				}else {
					o.setfName(fName);
					o.setlName(lName);
					o.setIdNum(idNum);
					o.setPhoneNumber(phoneNumber);
					o.setEmail(email);
					JOptionPane.showMessageDialog(null, "Occupant Edited Successfully");
					dispose();
                	new MainMenuUI();
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
		new EditOccupantUI().getOccupantIDUI(new TaylorAdmin()); 
	}
		
	
}
