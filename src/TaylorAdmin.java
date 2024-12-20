import java.util.ArrayList;

public class TaylorAdmin{

    private ArrayList<Block> blocks;


    public TaylorAdmin(){

        blocks = DataManager.loadData();

    }

    //Accessors

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public Block getBlock(char b){
        for(Block block:blocks){
            if(block.getBlock()==b){
                return block;
            }
        }
        return null;
    }

    public int getnumBlocks(){
        return blocks.size();
    }
    
    public void saveAllData(){                                      //Saves system data to text files for persistent storage

        DataManager.saveData(blocks);
    }

    public Room findByRoomIdNum(String roomID){
        
        for(Block block: blocks){

            if(block.getRoom(roomID)!=null){
                return block.getRoom(roomID);
            }
        }
        return null;
    }

    public ArrayList<Room> getAllRooms(){

        ArrayList<Room> rlst = new ArrayList<Room>();
        
        for(Block b:blocks){

            for(Room r: b.getRooms()){
                rlst.add(r);
                
            }
        }
        return rlst;
    }

    public ArrayList<Occupant> getAllOccupants() {
        ArrayList<Occupant> retList = new ArrayList<>();
        for (Room r:getAllRooms()) {
            retList.addAll(r.getOccupantLst());
        }
        return retList;
    }

    public Occupant getOccupant(int idNum){

        for(Block b: blocks){
            
            for(Room r :b.getRooms()){
                
                if(r.findOccupantByIdNum(idNum)!=null){

                    return r.findOccupantByIdNum(idNum);
                }
            }
        }
        return null;
    }
    
    public Room getRoomwithOccupantID(int idNum){

        for(Block b: blocks){
            
            for(Room r :b.getRooms()){
                
                if(r.findOccupantByIdNum(idNum)!=null){

                    return r;
                }
            }
        }
        return null;
    }


    //Mutators


    //Checks 

    public boolean isValidIdNumber(int idNum){

        for(Block b:blocks){                                        //Checks if anybody in any room on any block has the same id number 

            for(Room r: b.getRooms()){

                if(r.isRoomEmpty()!=true){
                    for(Occupant o: r.getOccupantLst()){
                        if(o.getIdNum()==idNum){

                            return false;                           //if so return false          
                        }
                    }
                }
            }
        }

        return true;                                               //If not return true 
    }

    // public static boolean isValidPhoneNumber(String str) {                           //Checks if user input is a valid phone number 
    //     // Check if the string matches the regex for digits only

    //     return !str.matches("\\d+"); // \\d+ matches one or more digits
    // }


    /*
    @Override
    public String toString(){
        String allBlocks = "Block: "+ getAllBlocks();
            return allBlocks;
    }*/
}