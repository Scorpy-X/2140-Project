public class Occupant{

    private String fName;
    private String lName;
    private int idNum;
    private String phoneNumber;
    private String email;

    //Remember to do Unique Id check, is id number a number less than 20 check, and conceptualize phone number formatting 

    public Occupant(){}

    public Occupant(String fName, String lName, int idNum, String phoneNumber, String email){

        this.fName = fName;
        this.lName = lName;
        this.idNum = idNum;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    //Accessors

    public String getfName() {
        return fName;
    }   

    public String getlName() {
        return lName;
    }

    public int getIdNum() {
        return idNum;
    }

    public String getIdNumstr() {
        return idNum +"";
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    
    

    //Mutators

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



}