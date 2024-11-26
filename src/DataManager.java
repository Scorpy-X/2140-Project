import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataManager {
	public static void createDatabase(){  //Initiailizes Database if not found
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
					state TEXT,
					room_id Text,
					FOREIGN KEY (room_id) REFERENCES Rooms (r_number))""";
			
			query ="SELECT name FROM sqlite_master WHERE type='table'";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("An error occurred: "+e.getMessage());
		}
	}
	
	
	public static void insertOccupant(Occupant p, String room_id){ //Inserts new occupant information into the occupant table
		String url= "jdbc:sqlite:Room_Information.db";
		try(Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()){
			String query = "INSERT INTO Occupant (idNum,fname,lname,phoneNumber,email,room_id) VALUES ("
							+p.getIdNum()+",'"
							+p.getfName()+"','"
							+p.getlName()+"','"
							+p.getPhoneNumber()+"','"
							+p.getEmail()+"','"
							+room_id+"')";
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
	
	
	public static void updateOccupant(long id, Occupant new_p, String room_id){//Updates an existing record in the Occupant Table
		String url= "jdbc:sqlite:Room_Information.db";
		try(Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()){
			String query = "UPDATE Occupant set idNum="+new_p.getIdNum()
						+",fname='"+new_p.getfName()+"'"
						+",lname='"+new_p.getlName()+"'"
						+",phoneNumber='"+new_p.getPhoneNumber()+"'"
						+",email='"+new_p.getEmail()+"'"
						+",room_id="+room_id+" WHERE idNum="+id; //Missing Room ID Parameter
			int num =stmt.executeUpdate(query);
			if(num==0) {
				System.out.println("No record with id number "+id+" was found.");
			}else{
				System.out.println("Update Successful");
			}
			
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
	
	public static void insertFurniture(Furniture f, String r_id){ //Inserts new furniture information into the occupant table
		String url= "jdbc:sqlite:Room_Information.db";
		try(Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()){
			String query = "INSERT INTO Furniture (type,state,room_id) VALUES ('"+f.getType()+"','"+f.getState()+"','"+r_id+ "')"; 
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
	
	public static void updateFurniture(long id, Furniture f, String room_id){//Updates an existing record in the Occupant Table
		String url= "jdbc:sqlite:Room_Information.db";
		try(Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()){
			String query = "UPDATE Furniture set idNum="
						+",type='"+f.getType()+"'"
						+",state='"+f.getState()+"'"
						+",room_id="+room_id+" WHERE idNum="+id; //Missing Room ID Parameter
			int num =stmt.executeUpdate(query);
			if(num==0) {
				System.out.println("No record with id number "+id+" was found.");
			}else{
				System.out.println("Update Successful");
			}
			
		}catch (SQLException e) {
			if (e.getMessage().contains("UNIQUE constraint failed")) {
                System.out.println("Error: Duplicate ID Number. Entry already exists.");
            } else {
                System.out.println("Database error: " + e.getMessage());
            }
		}
		
	}
	public static ArrayList<Furniture> current_furniture(String room_id){
		String url= "jdbc:sqlite:Room_Information.db";
		ArrayList<Furniture> furnitureList = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()){
			String query ="SELECT Furniture.id_num, Furniture.type, Furniture.state, Furniture.room_id, Rooms.r_number, Rooms.block"+
						  " FROM Furniture JOIN Rooms ON Furniture.room_id = Rooms.r_number"+
						  " WHERE Rooms.r_number = '"+room_id+"';";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				furnitureList.add(new Furniture(rs.getString("room_id"),rs.getString("type"),rs.getString("state")));
			}
			System.out.println(furnitureList.toString());
		}catch (SQLException e) {
			
            System.out.println("Database error: " + e.getMessage());
         
		}
		return furnitureList;
	}
		
	public static void clearDatabase() {
		String url= "jdbc:sqlite:Room_Information.db";
		try(Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()){
			String query = "DROP TABLE IF EXISTS Furniture";
			stmt.execute(query);
			query = "DROP TABLE IF EXISTS Rooms";
			stmt.execute(query);
			query = "DROP TABLE IF EXISTS Occupant";
			stmt.execute(query);
		}catch (SQLException e) {
			System.out.println("Database error: " + e.getMessage());
		}
		
	}
	
	
}