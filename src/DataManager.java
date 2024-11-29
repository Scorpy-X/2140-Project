import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataManager {
	public static final List<String>SingleRoomFurniture_LIST = List.of("Easy Chair","Bed","Mattrass","Closet","Coffee Table","Study Table","Chest of Draws","Wall","Window");
	public static final List<String> DoubleRoomFurniture_LIST = List.of("Easy Chair","Bed","Mattrass","Closet","Coffee Table","Study Table","Chest of Draws","Wall","Window","Easy Chair2","Bed2","Mattrass2","Closet2","Coffee Table2","Study Table2","Chest of Draws2","Wall2","Window2");
	public static final List<Character> Single_room_blocks = List.of('A','B','C','D'); 
	public static final List<Character> Double_room_blocks = List.of('E','F','G'); 
	
    public static void createFiles() {
        try { 
            
            File roomsFile = new File("rooms.txt");
            File occupantsFile = new File("occupants.txt");
            File furnitureFile = new File("furniture.txt");

            
            if (!roomsFile.exists() || roomsFile.length() == 0) { //Checks if files exist or are empty
                roomsFile.createNewFile();
                // Initialize with some default room data if the file is empty or newly created
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(roomsFile))) {
                	for(char c:Single_room_blocks){
                		for(int i=1;i<41;i++)
                			writer.write(""+c+i+","+c+",Single\n");
                	}
                	for(char c:Double_room_blocks){
                		for(int i=1;i<21;i++)
                			writer.write(""+c+i+","+c+",Double\n");
                	}
                    System.out.println("rooms.txt initialized with default data.");
                }
            }

            
            if (!occupantsFile.exists() || occupantsFile.length() == 0) {
                occupantsFile.createNewFile();
                // Initialize with some default occupant data if the file is empty or newly created
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(occupantsFile))) {
                    
                }
            }

            // Check and create the furniture.txt file if it doesn't exist or is empty
            if (!furnitureFile.exists() || furnitureFile.length() == 0) {
                furnitureFile.createNewFile();
                // Initialize with some default furniture data if the file is empty or newly created
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(furnitureFile))) {
                	String single_f = "Fair,Fair,Fair,Fair,Fair,Fair,Fair,Fair,Fair,";
                	String double_f = "Fair,Fair,Fair,Fair,Fair,Fair,Fair,Fair,Fair,Fair,Fair,Fair,Fair,Fair,Fair,Fair,Fair,Fair,";
                	for(char c:Single_room_blocks){
                		for(int i=1;i<41;i++)
                			writer.write(single_f+""+c+i+"\n");
                	}
                	for(char c:Double_room_blocks){
                		for(int i=1;i<21;i++)
                			writer.write(double_f+""+c+i+"\n");
                	}
                }
            }
        } catch (IOException e) {
            System.out.println("Error creating or initializing files: " + e.getMessage());
        }   
    }
    public static ArrayList<Block> loadData() {
    	DataManager.createFiles();
        ArrayList<Block> b_lst = new ArrayList<Block>();
		ArrayList<Room> r_lst;
		ArrayList<Occupant> o_lst;
		Map<String, String> furnituremap;
		String room_id;
        
        for(char c:Single_room_blocks){
        	r_lst = new ArrayList<>();
        	for(int i=1;i<41;i++) {
        		room_id = ""+c+i;
				o_lst = getOccupantsByRoomId(room_id);
				furnituremap = getTypeStateMap(room_id);
				
				getTypeStateMap(room_id);
				r_lst.add(new Room(room_id, c,
						o_lst.size() > 0 ? o_lst.get(0) : null,
						furnituremap.getOrDefault("Easy Chair", "Fair"),
						furnituremap.getOrDefault("Bed", "Fair"),
						furnituremap.getOrDefault("Mattrass", "Fair"),
						furnituremap.getOrDefault("Closet", "Fair"),
						furnituremap.getOrDefault("Coffee Table", "Fair"),
						furnituremap.getOrDefault("Study Table", "Fair"),
						furnituremap.getOrDefault("Chest of Draws", "Fair"),
						furnituremap.getOrDefault("Wall", "Fair"),
						furnituremap.getOrDefault("Window", "Fair")));
				
			}
        	b_lst.add(new Block(c,r_lst));
        }
        
        for(char c: Double_room_blocks){
        	r_lst = new ArrayList<>();
        	for(int i=1;i<21;i++) {
        		room_id = ""+c+i;
				o_lst = getOccupantsByRoomId(room_id);
				furnituremap = getTypeStateMap(room_id);
				r_lst.add(new Room(room_id, c,
				o_lst.size() > 0 ? o_lst.get(0) : null,
				o_lst.size() > 1 ? o_lst.get(1) : null,
				furnituremap.getOrDefault("Easy Chair", "Fair"),
				furnituremap.getOrDefault("Bed", "Fair"),
				furnituremap.getOrDefault("Mattrass", "Fair"),
				furnituremap.getOrDefault("Closet", "Fair"),
				furnituremap.getOrDefault("Coffee Table", "Fair"),
				furnituremap.getOrDefault("Study Table", "Fair"),
				furnituremap.getOrDefault("Chest of Draws", "Fair"),
				furnituremap.getOrDefault("Wall", "Fair"),
				furnituremap.getOrDefault("Window", "Fair"),
				furnituremap.getOrDefault("Easy Chair2", "Fair"),
				furnituremap.getOrDefault("Bed2", "Fair"),
				furnituremap.getOrDefault("Mattrass2", "Fair"),
				furnituremap.getOrDefault("Closet2", "Fair"),
				furnituremap.getOrDefault("Coffee Table2", "Fair"),
				furnituremap.getOrDefault("Study Table2", "Fair"),
				furnituremap.getOrDefault("Chest of Draws2", "Fair"),
				furnituremap.getOrDefault("Wall2", "Fair"),
				furnituremap.getOrDefault("Window2", "Fair")));
			}
        	b_lst.add(new Block(c,r_lst));
        }
        return b_lst;
    }
    
    public static void saveData(ArrayList<Block> block_lst) {
        try (BufferedWriter roomWriter = new BufferedWriter(new FileWriter("rooms.txt"));
             BufferedWriter occupantWriter = new BufferedWriter(new FileWriter("occupants.txt"));
             BufferedWriter furnitureWriter = new BufferedWriter(new FileWriter("furniture.txt"))) {

            for (Block b : block_lst) {
                ArrayList<Room> r_lst = b.getRooms();
                for (Room r : r_lst) {
                    roomWriter.write(r.getRoomID() + "," + r.getBlock() + "," + r.getRoomType()); // Save room details
                    roomWriter.newLine();

                    if (r.getOccupantLst() != null && !r.getOccupantLst().isEmpty()) {
                        for (Occupant o : r.getOccupantLst()) {  //Save Occupant details
                            occupantWriter.write(o.getIdNum() + "," + o.getfName() + "," + o.getlName() + ","
                                    + o.getPhoneNumber() + "," + o.getEmail() + "," + r.getRoomID());
                            occupantWriter.newLine();
                        }
                    }

                    ArrayList<Furniture> f_lst = r.getFurnitureLst();
                    for (Furniture f : f_lst) { 
                        furnitureWriter.write(f.getState() + "," ); // Save furniture details
                        
                    }
                    furnitureWriter.write(r.getRoomID());
                    furnitureWriter.newLine();
                }
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
    
    
    public static ArrayList<Occupant> getOccupantsByRoomId(String roomId) {
        ArrayList<Occupant> occupantsList = new ArrayList<>();
        
        // Read the occupants file
        try (BufferedReader reader = new BufferedReader(new FileReader("occupants.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
               
                if (parts.length == 6) {
                    String idnum = parts[0].trim();
                    String fname = parts[1].trim();
                    String lname = parts[2].trim();
                    String phoneNumber = parts[3].trim();
                    String email = parts[4].trim();
                    String room = parts[5].trim();
                    
                    // Check if the room ID matches the input room ID
                    if (room.equals(roomId)) {
                    	//Create and add that occupant to the list
                        occupantsList.add(new Occupant(fname,lname,Integer.parseInt(idnum),phoneNumber,email));
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading occupants file: " + e.getMessage());
        }
        
        return occupantsList;
    }
    
    public static Map<String,String> getTypeStateMap(String roomId) {
    	Map<String, String> typetoStateMap = new HashMap<>();

        
        // Read the occupants file
        try (BufferedReader reader = new BufferedReader(new FileReader("furniture.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
               
                if (parts.length == 10) {
                    String room = parts[9].trim();
                    
                    // Check if the room ID matches the input room ID
                    if (room.equals(roomId)) {
                    	
                    	for(int i=0;i<SingleRoomFurniture_LIST.size();i++){
                    		typetoStateMap.put(SingleRoomFurniture_LIST.get(i),parts[i].trim());
                    	}
                    	break;  
                    }
                }else if(parts.length == 19) {
                	String room = parts[18].trim();
                    
                    // Check if the room ID matches the input room ID
                    if (room.equals(roomId)) {
                    	for(int i=0;i<DoubleRoomFurniture_LIST.size();i++){
                    		typetoStateMap.put(DoubleRoomFurniture_LIST.get(i),parts[i].trim());
                    	}
                    	break;  
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading furniture file: " + e.getMessage());
        }
        
        return typetoStateMap;
    }
}

	
	