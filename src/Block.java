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
    public Room findRoom(String roomID){                //Returns room object if room exists and NUll otherwise 

        for(Room room: rooms){

            if(room.getRoomID().equalsIgnoreCase(roomID)){
                return room;
            }
        }
        
        return null;
        
    }

    public ArrayList<Room> getRooms(){

        return rooms;
    }
    
    public char getBlock(){

        return block;
    }

}