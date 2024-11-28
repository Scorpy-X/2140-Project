import java.util.ArrayList;

public class Block{

    private ArrayList<Room> rooms;
    private ArrayList<Occupant> occupants;          

    private char block;                     //Single character indicating block

    
    //private String blockName;               //Actual block name eg rooster 


    public Block(){}

    public Block(char block, ArrayList<Room> rooms) {


        this.rooms = rooms;
        this.block = block;
        
    }

    //Accessors
    public ArrayList<Room> getRooms(){

        return rooms;
    }
    
    public char getBlock(){

        return block;
    }

    public Room getRoom(String roomID){                                 //Return a room if a room by that id is found on the block          

        for(Room r: rooms){
            if(r.getRoomID().equals(roomID)){
                return r;
            }
        }
        return null;
    }

    public Room getRoom(int roomNum){                                   //Overloading for more use       

        for(Room r: rooms){
            if(r.getRoomID().equals(""+block+roomNum)){
                return r;
            }
        }
        return null;
    }

    

}