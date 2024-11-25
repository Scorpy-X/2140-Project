import java.util.ArrayList;

public class Room{

    private String roomNum;                 //alpha numeric room num with block letter 
    private ArrayList<Furniture> furnitureLst;
    private ArrayList<Furniture> furnitureLst2;
    private ArrayList<Occupant> occupantLst;
    private Occupant occupant1;
    private Occupant occupant2;


    private Furniture wall;
    private Furniture window;

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

    public Room(Occupant occupant1,                      //Room for 1 
                String easyChairState,                   //Use NULL on occupant if no occupant is in the room
                String bedState, 
                String mattrassState, 
                String closetState,
                String coffeeTableState, 
                String studyTableState, 
                String chestOfDrawsState, 
                String wallState, 
                String windowState){   
                    
        furnitureLst = new ArrayList<Furniture>();
        occupantLst = new ArrayList<Occupant>();

        

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


    public Room(){          //Room for 2 with no occupants 


    }

    public Room(){          //Room for 2 with occupants 

        
    }

    




}