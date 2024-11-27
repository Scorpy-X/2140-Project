import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataManager {
	public static final List<String> SingleRoomFurniture_LIST = List.of("Easy Chair","Bed","Mattrass","Closet","Coffee Table","Study Table","Chest of Draws","Wall","Window");
	public static final List<String> DoubleRoomFurniture_LIST = List.of("Easy Chair","Bed","Mattrass","Closet","Coffee Table","Study Table","Chest of Draws","Wall","Window","Easy Chair2","Bed2","Mattrass2","Closet2","Coffee Table2","Study Table2","Chest of Draws2","Wall2","Window2");
	
	public static void createDatabase(){  //Initiailizes Database if not found
		String url= "jdbc:sqlite:Room_Information.db";
		try(Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()){
			if(!doesTableExist(conn,"Rooms")) { //Checks if table exists before creating
				String query = """
					CREATE TABLE IF NOT EXISTS Rooms(
					r_number Text PRIMARY KEY,
					block TEXT,
					room_type TEXT)""";
				stmt.execute(query);
				for(char c: List.of('A','B','C','D')){
					for(int i=1;i<41;i++) {
						stmt.execute("INSERT INTO Rooms (r_number,block,room_type) VALUES ('"+c+""+i+"','"+c+"','Single')");
					}
				}
				for(char c: List.of('E','F','G')){
					for(int i=1;i<21;i++) {
						stmt.execute("INSERT INTO Rooms (r_number,block,room_type) VALUES ('"+c+""+i+"','"+c+"','Double')");
					}
				}
			}
			
			if(!doesTableExist(conn,"Occupant")) { 
				String query = """
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
			}
			if(!doesTableExist(conn,"Furniture")) {
			String query = """
					CREATE TABLE IF NOT EXISTS Furniture(
					type TEXT,
					state TEXT,
					room_id Text,
					PRIMARY KEY (type, room_id),
					FOREIGN KEY (room_id) REFERENCES Rooms (r_number))""";
			stmt.execute(query);
			for(char c: List.of('A','B','C','D')){
				for(int i=1;i<41;i++) {
					String room_id = ""+c+i;
					for(String s:SingleRoomFurniture_LIST)
						stmt.execute("INSERT INTO Furniture (type,state,room_id) VALUES ('"+s+"','"+"Fair"+"','"+room_id+"')");
				}
			}
			for(char c: List.of('E','F','G')){
				for(int i=1;i<21;i++) {
					String room_id = ""+c+i;
					for(String s:DoubleRoomFurniture_LIST)
						stmt.execute("INSERT INTO Furniture (type,state,room_id) VALUES ('"+s+"','"+"Fair"+"','"+room_id+"')");
				}
			}
			}
			
		} catch (SQLException e) {
			System.out.println("An error occurred: "+e.getMessage());
		}
	}
	public static ArrayList<Block> loadData(){
		ArrayList<Block> b_lst = new ArrayList<Block>();
		ArrayList<Room> r_lst = new ArrayList<Room>();
		ArrayList<Occupant> o_lst = new ArrayList<Occupant>();
		Map<String, String> furnituremap = new HashMap<>();
		String room_id;
		for(char c: List.of('A','B','C','D')) {
			for(int i=1;i<41;i++) {
				room_id = ""+c+i;
				o_lst = current_Occupants(room_id);
				furnituremap = getTypeStateMap(room_id);
				String easyChairState = furnituremap.get("Easy Chair");
				String bedState = furnituremap.get("Bed");
				String mattrassState = furnituremap.get("Mattrass");
				String closetState = furnituremap.get("Closet");
				String coffeeTableState = furnituremap.get("Coffee Table");
				String studyTableState = furnituremap.get("Study Table");
				String chestOfDrawsState = furnituremap.get("Chest of Draws");
				String wallState = furnituremap.get("Wall");
				String windowState = furnituremap.get("Window");
				if(o_lst.size()==0) {
					r_lst.add(new Room(room_id,c,null,easyChairState,bedState,mattrassState,closetState,coffeeTableState,studyTableState,chestOfDrawsState,wallState,windowState));
				}else{
					r_lst.add(new Room(room_id,c,o_lst.get(0),easyChairState,bedState,mattrassState,closetState,coffeeTableState,studyTableState,chestOfDrawsState,wallState,windowState));
				}
			}
			b_lst.add(new Block(c,r_lst));
			r_lst = new ArrayList<Room>();
		}
		for(char c: List.of('E','F','G')) {
			for(int i=1;i<21;i++) {
				room_id = ""+c+i;
				o_lst = current_Occupants(room_id);
				furnituremap = getTypeStateMap(room_id);
				String easyChairState = furnituremap.get("Easy Chair");
				String bedState = furnituremap.get("Bed");
				String mattrassState = furnituremap.get("Mattrass");
				String closetState = furnituremap.get("Closet");
				String coffeeTableState = furnituremap.get("Coffee Table");
				String studyTableState = furnituremap.get("Study Table");
				String chestOfDrawsState = furnituremap.get("Chest of Draws");
				String wallState = furnituremap.get("Wall");
				String windowState = furnituremap.get("Window");
				String easyChairState2 = furnituremap.get("Easy Chair2");
				String bedState2 = furnituremap.get("Bed2");
				String mattrassState2 = furnituremap.get("Mattrass2");
				String closetState2 = furnituremap.get("Closet2");
				String coffeeTableState2 = furnituremap.get("Coffee Table2");
				String studyTableState2 = furnituremap.get("Study Table2");
				String chestOfDrawsState2 = furnituremap.get("Chest of Draws2");
				String wallState2 = furnituremap.get("Wall2");
				String windowState2 = furnituremap.get("Window2");
				if(o_lst.size()==0) {
					r_lst.add(new Room(room_id,c,null,null,easyChairState,bedState,mattrassState,closetState,coffeeTableState,studyTableState,chestOfDrawsState,wallState,windowState,
							easyChairState2,bedState2,mattrassState2,closetState2,coffeeTableState2,studyTableState2,chestOfDrawsState2,wallState2,windowState2));
				}else if(o_lst.size()==1){
					r_lst.add(new Room(room_id,c,o_lst.get(0),null,easyChairState,bedState,mattrassState,closetState,coffeeTableState,studyTableState,chestOfDrawsState,wallState,windowState,
							easyChairState2,bedState2,mattrassState2,closetState2,coffeeTableState2,studyTableState2,chestOfDrawsState2,wallState2,windowState2));
				}else{
					r_lst.add(new Room(room_id,c,o_lst.get(0),o_lst.get(1),easyChairState,bedState,mattrassState,closetState,coffeeTableState,studyTableState,chestOfDrawsState,wallState,windowState,
							easyChairState2,bedState2,mattrassState2,closetState2,coffeeTableState2,studyTableState2,chestOfDrawsState2,wallState2,windowState2));
				}
			}
			b_lst.add(new Block(c,r_lst)); 
			r_lst = new ArrayList<Room>();
		}
		
		return b_lst;
	}
	 
	public static void saveData(ArrayList<Block> block_lst){
		DataManager.clearTables();
		for(Block b: block_lst){
			ArrayList<Room> r_lst = b.getRooms();
			for(Room r: r_lst){
				ArrayList<Furniture> f_lst = r.getFurnitureLst();
				ArrayList<Occupant> o_lst = r.getOccupantLst();
				int i=0;
				if (o_lst != null) {
					for(Occupant o:o_lst) {
						if(o!=null)
							DataManager.insertOccupant(o,r.getRoomID());
					}
				}
				if(List.of('A', 'B', 'C', 'D').contains(r.getBlock())){
					for(String s:SingleRoomFurniture_LIST){
						updateFurniture(r.getRoomID(),s,f_lst.get(i).getState());
						i++;
					} 
				}else{
					for(String s:DoubleRoomFurniture_LIST){
						updateFurniture(r.getRoomID(),s,f_lst.get(i).getState());
						i++;
					}
				}
			}
			
		}		
	}
	
	private static Map<String, String> getTypeStateMap(String room_id) {
	    String url = "jdbc:sqlite:Room_Information.db";
	    Map<String, String> typetoStateMap = new HashMap<>();

	    try (Connection conn = DriverManager.getConnection(url);
	         Statement stmt = conn.createStatement()) {
	         
	        String query = "SELECT type, state FROM Furniture WHERE room_id ='" + room_id + "'";
	        ResultSet rs = stmt.executeQuery(query);

	        while (rs.next()) {
	            String type = rs.getString("type");
	            String state = rs.getString("state");
	            typetoStateMap.put(type, state);
	        }

	    } catch (SQLException e) {
	        System.out.println("Database error: " + e.getMessage());
	    }
	    return typetoStateMap;
	}
	
	public static boolean insertOccupant(Occupant p, String room_id){ //Inserts new occupant information into the occupant table
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
			return true;
		}catch (SQLException e) {
			if (e.getMessage().contains("UNIQUE constraint failed")) {
                System.out.println("Error: Duplicate ID Number. Entry already exists.");
            } else {
                System.out.println("Database error: " + e.getMessage());
            }
			return false;
		}
	}
	
	public static void clearTables() {
	    String url = "jdbc:sqlite:Room_Information.db";

	    try (Connection conn = DriverManager.getConnection(url);
	         Statement stmt = conn.createStatement()) {


	        // Delete all records from the Occupant table
	        String clearOccupantQuery = "DELETE FROM Occupant";
	        stmt.executeUpdate(clearOccupantQuery);
	        System.out.println("Occupant table cleared.");

	    } catch (SQLException e) {
	        System.out.println("Database error: " + e.getMessage());
	    }
	}
	

	
	public static void updateFurniture(String room_id, String type, String state){//Updates an existing record in the Occupant Table
		String url= "jdbc:sqlite:Room_Information.db";
		try(Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()){
			String query = "UPDATE Furniture set"
						+" state='"+state+"'"
						+" WHERE room_id='"+room_id+"' AND type ='"+type+"'"; //Missing Room ID Parameter
			int num =stmt.executeUpdate(query);
			if(num==0) {
				System.out.println("No furniture record of type"+type+" was found in room with id "+room_id);
			}else{
				//System.out.println("Update Successful");
			}
			
		}catch (SQLException e) {
			if (e.getMessage().contains("UNIQUE constraint failed")) {
                System.out.println("Error: Duplicate ID Number. Entry already exists.");
            } else {
                System.out.println("Database error: " + e.getMessage());
            }
		}
		
	}
	
	
	public static ArrayList<Occupant> current_Occupants(String room_id){
		String url= "jdbc:sqlite:Room_Information.db";
		ArrayList<Occupant> occupantList = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()){
			String query ="SELECT *"+
						  " FROM Occupant JOIN Rooms ON Occupant.room_id = Rooms.r_number"+
						  " WHERE Rooms.r_number = '"+room_id+"';";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				occupantList.add(new Occupant(rs.getString("fname"),rs.getString("lname"),rs.getInt("idNum"),rs.getString("phoneNumber"),rs.getString("email")));
			}
		}catch (SQLException e) {
			
            System.out.println("Database error: " + e.getMessage());
         
		}
		return occupantList;
	}
	
	public static boolean doesTableExist(Connection conn, String tableName) {
	    String query = "SELECT name FROM sqlite_master WHERE type='table' AND name='" + tableName + "';";
	    try (Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(query)) {
	        return rs.next(); // Returns true if the table exists
	    } catch (SQLException e) {
	        System.out.println("Error checking table existence: " + e.getMessage());
	        return false; // Return false if there's an error
	    }
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