
public class Furniture{

  
    private String state;

    //Discuss making state a integer {1-10}

    public Furniture(){}

    public Furniture(String state){

        this.state = state;
    }

    //Accessors 
 

    public String getState() {
        return state;
    }


    //Mutators

    public void setState(String state) {
        this.state = state;
    }

}