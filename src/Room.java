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

    public Room(/*String roomNum,char block*/){
    	// this.roomNum = roomNum;
    	// this.block = block;
    	// furnitureLst = new ArrayList<Furniture>();
        // occupantLst = new ArrayList<Occupant>();
    }

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

    




    public boolean addOccupant(Occupant o) {
        if(DataManager.insertOccupant(o)){
            this.occupantLst.add(o);
            return true; //returns true when occcupant is added successfully 
        }else {
            return false; //returns false when occupant cannot be added
        }
    }

    public boolean updateOccupant(Occupant o) {
        if(DataManager.insertOccupant(o)){
            this.occupantLst.add(o);
            return true; //returns true when occcupant is added successfully 
        }else {
            return false; //returns false when occupant cannot be added
        }
    }


}