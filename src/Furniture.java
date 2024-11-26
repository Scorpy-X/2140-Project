
public class Furniture{

  
    private String state;
    private String room_id;
    private String type;

    //Discuss making state a integer {1-10}

    public Furniture(){}

    public Furniture(String room_id, String type, String state){

        this.state = state;
        this.room_id = room_id;
        this.type = type;
    }

    //Accessors 
 

    public String getState() {
        return state;
    }
    
    public String getType() {
        return type;
    }
    
    public String getRoom_id() {
        return room_id;
    }


    //Mutators

    public void setState(String state) {
        this.state = state;
    }

}