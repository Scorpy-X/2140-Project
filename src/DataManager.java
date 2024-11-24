import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataManager {
	public static void createDatabase(){
		String url= "jdbc:sqlite:Room_Information.db";
		try(Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()){
			
			String query = """
				CREATE TABLE IF NOT EXISTS Rooms(
				r_number Text PRIMARY KEY,
				block TEXT)""";
			stmt.execute(query);
			query = """
					CREATE TABLE IF NOT EXISTS Occupant( 
					idNum INTEGER PRIMARY KEY,
					fname TEXT,
					lname TEXT,
					phoneNumber TEXT,
					email TEXT,
					start_date TEXT,
					end_date TEXT,
					room_id Text,
					FOREIGN KEY (room_id) REFERENCES Rooms (r_number))""";
			stmt.execute(query);
			query = """
					CREATE TABLE IF NOT EXISTS Furniture(
					id_num INTEGER PRIMARY KEY,
					type TEXT,
					condition TEXT,
					description TEXT,
					room_id Text,
					FOREIGN KEY (room_id) REFERENCES Rooms (r_number))""";
			stmt.execute(query);
			query ="SELECT name FROM sqlite_master WHERE type='table'";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("An error occurred: "+e.getMessage());
		}
	}
	public static void insertOccupant(Occupant p){ //Inserts new occupant information into the occupant table
		String url= "jdbc:sqlite:Room_Information.db";
		try(Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()){
			String query = "INSERT INTO Occupant (idNum,fname,phoneNumber,email,room_id) VALUES ("+p.getIdNum()+",'"+p.getfName()+"','"+p.getPhoneNumber()+"','"+p.getEmail()+"',1"+")"; //Missing Room ID Parameter
			stmt.execute(query);
			System.out.println("Insert Successful");
		}catch (SQLException e) {
			if (e.getMessage().contains("UNIQUE constraint failed")) {
                System.out.println("Error: Duplicate ID Number. Entry already exists.");
            } else {
                System.out.println("Database error: " + e.getMessage());
            }
		}
	}
	
	
	public static void updateOccupant(long id, Occupant new_p){//Updates an existing record in the Occupant Table
		String url= "jdbc:sqlite:Room_Information.db";
		try(Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()){
			String query = "UPDATE Occupant set idNum="+new_p.getIdNum()
						+",fname='"+new_p.getfName()+"'"
						+",phoneNumber='"+new_p.getPhoneNumber()+"'"
						+",email='"+new_p.getEmail()+"'"
						+",room_id="+"1 WHERE idNum="+id; //Missing Room ID Parameter
			stmt.execute(query);
			System.out.println("Update Successful");
		}catch (SQLException e) {
			if (e.getMessage().contains("UNIQUE constraint failed")) {
                System.out.println("Error: Duplicate ID Number. Entry already exists.");
            } else {
                System.out.println("Database error: " + e.getMessage());
            }
		}
		
	}
	
	public static void showOccupants(){ //Displays existing Occupant info to the console
		String url= "jdbc:sqlite:Room_Information.db";
		try(Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()){
			String query = "SELECT * FROM Occupant"; //Missing Room ID Parameter
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				 int idNum = rs.getInt("idNum");        
				    String fname = rs.getString("fname");  
				    String lname = rs.getString("lname");  
				    String phoneNumber = rs.getString("phoneNumber");  
				    String email = rs.getString("email");  
				    
				    System.out.println("ID: " + idNum + ", First Name: " + fname + ", Last Name: " + lname +
				                       ", Phone Number: " + phoneNumber + ", Email: " + email);
			}
		}catch (SQLException e) {
			
                System.out.println("Database error: " + e.getMessage());
		}
	}
	
	
}