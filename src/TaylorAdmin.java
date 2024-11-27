import java.util.ArrayList;

public class TaylorAdmin{

    private ArrayList<Block> blocks;


    public TaylorAdmin(){}

    public TaylorAdmin(){

        ArrayList<Room> BlockARooms = new ArrayList<Room>();
        ArrayList<Room> BlockBRooms = new ArrayList<Room>();
        ArrayList<Room> BlockCRooms = new ArrayList<Room>();
        ArrayList<Room> BlockDRooms = new ArrayList<Room>();

        ArrayList<Room> BlockERooms = new ArrayList<Room>();
        ArrayList<Room> BlockFRooms = new ArrayList<Room>();
        ArrayList<Room> BlockGRooms = new ArrayList<Room>();

        for(int i=1; i<41;i++){                     //Making block A rooms

            String roomID = "A" + i;

            Room room =new Room(roomID,
                        'A', 
                        null, 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent");

            BlockARooms.add(room);
        }

        for(int i=1; i<41;i++){                     //Making block B rooms

            String roomID = "B" + i;

            Room room =new Room(roomID,
                        'B', 
                        null, 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent");

            BlockBRooms.add(room);
        }

        for(int i=1; i<41;i++){                     //Making block C rooms

            String roomID = "C" + i;

            Room room =new Room(roomID,
                        'C', 
                        null, 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent");

            BlockCRooms.add(room);
        }

        for(int i=1; i<41;i++){                     //Making block D rooms

            String roomID = "D" + i;

            Room room =new Room(roomID,
                        'D', 
                        null, 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent");

            BlockDRooms.add(room);
        }

        for(int i=1; i<21;i++){                     //Making block E rooms

            String roomID = "E" + i;

            Room room =new Room(roomID,
                        'E', 
                        null,
                        null, 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent",

                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent",
                        "Excellent");

            BlockERooms.add(room);

            
        }

        for(int i=1; i<21;i++){                     //Making block F rooms

            String roomID = "F" + i;

            Room room =new Room(roomID,
                        'F', 
                        null,
                        null, 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent",

                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent",
                        "Excellent");

            BlockFRooms.add(room);
        }

        for(int i=1; i<21;i++){                 //Making block G rooms

            String roomID = "G" + i;

            Room room =new Room(roomID,
                        'G', 
                        null,
                        null, 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent",

                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent", 
                        "Excellent",
                        "Excellent");

            BlockGRooms.add(room);

        }

        Block A = new Block('A', BlockARooms);
        Block B = new Block('B', BlockBRooms);
        Block C = new Block('C', BlockCRooms);
        Block D = new Block('D', BlockDRooms);

        Block E = new Block('E', BlockERooms);
        Block F = new Block('F', BlockFRooms);
        Block G = new Block('G', BlockGRooms);
    }

   
























}