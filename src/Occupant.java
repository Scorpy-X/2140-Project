public class Occupant{

    private String fName;
    private String lName;
    private int idNum;
    private String phoneNumber;
    private String email;

    //Remember to do Unique Id check, is id number a number less than 20 digits check, and conceptualize phone number formatting, phone number all digits check 

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


    //Checks 

    public static boolean isValidPhoneNumber(String str) {                           //Checks if user input is a valid phone number 
        // Check if the string matches the regex for digits only

        return !str.matches("\\d+"); // \\d+ matches one or more digits
    }

}