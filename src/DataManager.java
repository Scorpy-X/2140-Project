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
                			writer.write(""+c+i+","+c+",Single\n");;
                	}
                	for(char c:Double_room_blocks){
                		for(int i=1;i<21;i++)
                			writer.write(""+c+i+","+c+",Double\n");;
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
		ArrayList<Room> r_lst = new ArrayList<Room>();
		ArrayList<Occupant> o_lst = new ArrayList<Occupant>();
		Map<String, String> furnituremap = new HashMap<>();
		String room_id;
        
        for(char c:Single_room_blocks){
        	for(int i=1;i<41;i++) {
        		room_id = ""+c+i;
				o_lst = getOccupantsByRoomId(room_id);
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
        for(char c: Double_room_blocks){
        	for(int i=1;i<21;i++) {
        		room_id = ""+c+i;
				o_lst = getOccupantsByRoomId(room_id);
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
    
    public static void saveData(ArrayList<Block> block_lst) {
        try (BufferedWriter roomWriter = new BufferedWriter(new FileWriter("rooms.txt"));
             BufferedWriter occupantWriter = new BufferedWriter(new FileWriter("occupants.txt"));
             BufferedWriter furnitureWriter = new BufferedWriter(new FileWriter("furniture.txt"))) {

            for (Block b : block_lst) {
                ArrayList<Room> r_lst = b.getRooms();
                for (Room r : r_lst) {
                    
                    roomWriter.write(r.getRoomID() + "," + r.getBlock() + "," + r.getRoomType()); // Save room details
                    roomWriter.newLine();

                    
                    if (r.getOccupantLst() != null) {
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
                    String fname = parts[1];
                    String lname = parts[2];
                    String phoneNumber = parts[3];
                    String email = parts[4];
                    String room = parts[5].trim();
                    
                    // Check if the room ID matches the input room ID
                    if (room.equals(roomId)) {
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
                    	int i = 0;
                    	for(String s: SingleRoomFurniture_LIST) {
                    		typetoStateMap.put(s,parts[i]);
                    		i++;
                    	}
                    	break;  
                    }
                }else if(parts.length == 19) {
                	String room = parts[18].trim();
                    
                    // Check if the room ID matches the input room ID
                    if (room.equals(roomId)) {
                    	int i_2 = 0;
                    	for(String s: DoubleRoomFurniture_LIST) {
                    		typetoStateMap.put(s,parts[i_2]);
                    		i_2++;
                    	}
                    	break;  
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading occupants file: " + e.getMessage());
        }
        
        return typetoStateMap;
    }
}