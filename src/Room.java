import java.util.ArrayList;

public class Room{

    private String roomID;                 //alpha numeric room num with block letter 
    private char block;                   //Single letter with block letter 
    private String blockName; 

    private String roomType;
    
    private ArrayList<Furniture> furnitureLst;
    //private ArrayList<Furniture> furnitureLst2;
    private ArrayList<Occupant> occupantLst;
    private Occupant occupant1;
    private Occupant occupant2;


    private Furniture wall;
    private Furniture window;
    private Furniture wall2;
    private Furniture window2;

    private Furniture easyChair;
    private Furniture bed;
    private Furniture mattrass;
    private Furniture closet;
    private Furniture coffeeTable;
    private Furniture studyTable;
    private Furniture chestOfDraws;

    private Furniture easyChair2;
    private Furniture bed2;
    private Furniture mattrass2;
    private Furniture closet2;
    private Furniture coffeeTable2;
    private Furniture studyTable2;
    private Furniture chestOfDraws2;

    public Room(){}

    public Room(String roomID,
                char block,
                Occupant occupant1,                      //Room for 1 
                String easyChairState,                   //Use NULL on occupant if no occupant is in the room
                String bedState, 
                String mattrassState, 
                String closetState,
                String coffeeTableState, 
                String studyTableState, 
                String chestOfDrawsState, 
                String wallState, 
                String windowState){   
                
        this.roomType = "Single";
                    
        furnitureLst = new ArrayList<Furniture>();
        occupantLst = new ArrayList<Occupant>();

        this.block = block;
        this.roomID = roomID;

        if(occupant1==null){
            this.occupant1 = null;
        }

        else{
            this.occupant1 = occupant1;
            occupantLst.add(occupant1);
        }


        this.easyChair = new Furniture(easyChairState);
        this.bed = new Furniture(bedState);
        this.mattrass = new Furniture(mattrassState);
        this.closet = new Furniture(closetState);
        this.coffeeTable = new Furniture(coffeeTableState);
        this.studyTable = new Furniture(studyTableState);
        this.chestOfDraws = new Furniture(chestOfDrawsState);
        this.wall = new Furniture(wallState);
        this.window = new Furniture(windowState);


        this.furnitureLst.add(this.easyChair);
        this.furnitureLst.add(this.bed);
        this.furnitureLst.add(this.mattrass);
        this.furnitureLst.add(this.closet);
        this.furnitureLst.add(this.coffeeTable);
        this.furnitureLst.add(this.studyTable);
        this.furnitureLst.add(this.chestOfDraws);
        this.furnitureLst.add(this.wall);
        this.furnitureLst.add(this.window);

    }


    public Room(String roomID,                                  //Room for 2 
                char block,
                Occupant occupant1,                         //Use NULL on occupant if no occupant is in the room
                Occupant occupant2, 

                String easyChairState,                  
                String bedState, 
                String mattrassState, 
                String closetState,
                String coffeeTableState, 
                String studyTableState, 
                String chestOfDrawsState, 
                String wallState, 
                String windowState,

                String easyChairState2,                  
                String bedState2, 
                String mattrassState2, 
                String closetState2,
                String coffeeTableState2, 
                String studyTableState2, 
                String chestOfDrawsState2, 
                String wallState2, 
                String windowState2){          

        this.roomType = "Double";
                    
        furnitureLst = new ArrayList<Furniture>();
        occupantLst = new ArrayList<Occupant>();
            
        this.block = block;
        this.roomID = roomID;
            
        if(occupant1==null){
            this.occupant1 = null;
        }
            
        else{
            this.occupant1 = occupant1;
            occupantLst.add(occupant1);
        }

        if(occupant2==null){
            this.occupant2 = null;
        }
            
        else{
            this.occupant2 = occupant2;
            occupantLst.add(occupant2);             //@Justin should this be different based on your methods or those only on update 
        }
    
        

        this.easyChair = new Furniture(easyChairState);             //First furniture set 
        this.bed = new Furniture(bedState);
        this.mattrass = new Furniture(mattrassState);
        this.closet = new Furniture(closetState);
        this.coffeeTable = new Furniture(coffeeTableState);
        this.studyTable = new Furniture(studyTableState);
        this.chestOfDraws = new Furniture(chestOfDrawsState);
        this.wall = new Furniture(wallState);
        this.window = new Furniture(windowState);


        this.furnitureLst.add(this.easyChair);
        this.furnitureLst.add(this.bed);
        this.furnitureLst.add(this.mattrass);
        this.furnitureLst.add(this.closet);
        this.furnitureLst.add(this.coffeeTable);
        this.furnitureLst.add(this.studyTable);
        this.furnitureLst.add(this.chestOfDraws);
        this.furnitureLst.add(this.wall);
        this.furnitureLst.add(this.window);


        this.easyChair2 = new Furniture(easyChairState2);         //Second furniture set
        this.bed2 = new Furniture(bedState2);
        this.mattrass2 = new Furniture(mattrassState2);
        this.closet2 = new Furniture(closetState2);
        this.coffeeTable2 = new Furniture(coffeeTableState2);
        this.studyTable2 = new Furniture(studyTableState2);
        this.chestOfDraws2 = new Furniture(chestOfDrawsState2);
        this.wall2 = new Furniture(wallState2);
        this.window2 = new Furniture(windowState2);


        this.furnitureLst.add(this.easyChair2);
        this.furnitureLst.add(this.bed2);
        this.furnitureLst.add(this.mattrass2);
        this.furnitureLst.add(this.closet2);
        this.furnitureLst.add(this.coffeeTable2);
        this.furnitureLst.add(this.studyTable2);
        this.furnitureLst.add(this.chestOfDraws2);
        this.furnitureLst.add(this.wall2);
        this.furnitureLst.add(this.window2);



    }

    //Accessors 

    public String getRoomID() {
        return roomID;
    }

    public char getBlock() {
        return block;
    }

    // public String getBlockName() {
    //     return blockName;
    // }

    public String getRoomType() {                    //Single or Double
        return roomType;
    }

    public ArrayList<Furniture> getFurnitureLst() {
        return furnitureLst;
    }

    public ArrayList<Occupant> getOccupantLst() {
        return occupantLst;
    }

                                                                //Furniture Set 1

    public Furniture getEasyChair() {           //Use to update Easy Chair #1
        return easyChair;
    }

    public Furniture getBed() {                 //Use to update Bed #1
        return bed;
    }

    public Furniture getMattrass() {            //Use to update Mattrass #1
        return mattrass;
    }

    public Furniture getCloset() {              //Use to update Closet #1
        return closet;
    }

    public Furniture getCoffeeTable() {         //Use to update Coffee Table #1
        return coffeeTable;
    }

    public Furniture getStudyTable() {          //Use to update Study Table #1
        return studyTable;
    }

    public Furniture getChestOfDraws() {        //Use to update Chest of Draws #1
        return chestOfDraws;
    }

    public Furniture getWall() {                //Use to update Wall #1
        return wall;
    }

    public Furniture getWindow() {              //Use to update Window #1
        return window;
    }
                                                                            //Furniture set 2

    public Furniture getEasyChair2() {          //Use to update Easy Chair #2
        return easyChair2;
    }

    public Furniture getBed2() {                //Use to update Bed #2
        return bed2;
    }

    public Furniture getMattrass2() {           //Use to update Mattrass #2
        return mattrass2;
    }

    public Furniture getCloset2() {             //Use to update Closet #2
        return closet2;
    }

    public Furniture getCoffeeTable2() {        //Use to update Coffee Table #2
        return coffeeTable2;
    }

    public Furniture getStudyTable2() {         //Use to update Study Table #2
        return studyTable2;
    }

    public Furniture getChestOfDraws2() {       //Use to update Chest of Draws #2
        return chestOfDraws2;
    }

    public Furniture getWall2() {               //Use to update Wall #2
        return wall2;
    }

    public Furniture getWindow2() {             //Use to update Window #2
        return window2;
    }




    //Mutators

    public boolean addOccupant(Occupant o) {                //Checks if room is not full then adds an occupant 
        
        if (isRoomFull()!=true){
            this.occupantLst.add(o);
            return true;
        }

        else
            return false;    
    }

    public boolean removeOccupant(Occupant o){              //Checks if occupant is in room them removes them
        if (occupantLst.contains(o)){

            occupantLst.remove(o);

            return true;
        }
        else
            return false;
    }

   

    


    //Checks 

    public boolean isRoomFull(){
        if (roomType=="Single"){
            return occupantLst.size()==1;
        }
        else{
            return occupantLst.size()==2;
        }
    }

    public boolean isRoomEmpty(){
        
            return occupantLst.size()==0;
        
    }

    public boolean isOccupantInRoom(Occupant o){                    //Takes an occupant and checks if this occupant is in the room 

        return occupantLst.contains(o);
    }

    public int getFurnitureCount(){

        return furnitureLst.size();
    }

    public Occupant findOccupantByName(String fName, String lName) {

        if (isRoomEmpty()!=true){
            for (Occupant occupant : occupantLst) {
                if (occupant.getfName().equalsIgnoreCase(fName) && occupant.getlName().equalsIgnoreCase(lName)) { // Assuming Occupant has a getName() method
                    return occupant;
                }
            }
        }

        return null; // Return null if no occupant with the given name is found
    }

    public Occupant findOccupantByIdNum(int idNum) {

        if (isRoomEmpty()!=true){
            for (Occupant occupant : occupantLst) {
                if (occupant.getIdNum()==idNum){ // Assuming Occupant has a getName() method
                    return occupant;
                }
            }
        }

        return null; // Return null if no occupant with the given name is found
    }

    public int getNumOccupants(){           //Returns the number of occupants in this room

        return occupantLst.size();

    }

    public int getExcellentFurnitureCount(){        //Returns count of excellent condition furniture present in this room

        int count= 0;

        for(Furniture f: furnitureLst){
            if(f.getState()=="Excellent"){
                count =count+1;
            }
        }

        return count;
    }


    public int getFairFurnitureCount(){             //Returns count of Fair condition furniture present in this room

        int count= 0;

        for(Furniture f: furnitureLst){
            if(f.getState()=="Fair"){
                count =count+1;
            }
        }
        
        return count;
    }

    public int getPoorFurnitureCount(){             //Returns count of Poor condition furniture present in this room

        int count= 0;

        for(Furniture f: furnitureLst){
            if(f.getState()=="Poor"){
                count =count+1;
            }
        }
        
        return count;
    }

    public int getMissingFurnitureCount(){          //Returns count of Missing furniture for this room

        int count= 0;

        for(Furniture f: furnitureLst){
            if(f.getState()=="None"){
                count =count+1;
            }
        }
        
        return count;
    }




}