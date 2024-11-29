import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteOccupantUI extends JFrame {
	private JTextField idNumF;
	public void getOccupantIDUI(TaylorAdmin th, int a_lvl){
		setTitle("ID Number of Student to be deleted");
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
				if(!th.isValidIdNumber(idNum)) {
					Occupant o = th.getOccupant(idNum);
					o = null;
					dispose();
					JOptionPane.showMessageDialog(null, "The occupant was deleted.");
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
	public static void main(String[] args) { 
		new DeleteOccupantUI().getOccupantIDUI(new TaylorAdmin(),1); 
	}
		
	
}
