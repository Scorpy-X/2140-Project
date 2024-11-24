
public class Main { //Small Demonstration of database methods 
	public static void main(String[] args){
		DataManager.createDatabase();
		DataManager.showOccupants(); //Shows which occupants are currently stored in the database
		Occupant pete = new Occupant("Peter", "Morg", 620153044, "(876)123-2344", "Petersalrgiht@gmail.com");
		DataManager.insertOccupant(pete);//Confirming that duplicates arent allowed
		Occupant pete2 = new Occupant("Peter", "Morg", 620153032, "(876)123-2344", "Petersaintalright@gmail.com");
		DataManager.updateOccupant(620153044,pete2);//Altering 
		DataManager.showOccupants();
	}
}
