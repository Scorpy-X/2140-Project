
public class Furniture{

    private String type;
    private String state;

    //Discuss making state a integer {1-10}

    public Furniture(){}

    public Furniture(String type, String state){

        this.type = type;
        this.state = state;

    }

    //Accessors 
    public String getType() {
        return type;
    }

    public String getState() {
        return state;
    }


    //Mutators

    public void setState(String state) {
        this.state = state;
    }

}