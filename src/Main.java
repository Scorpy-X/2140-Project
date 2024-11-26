import java.util.ArrayList;

public class Main { //Small Demonstration of database methods 
	public static void main(String[] args){
		DataManager.clearDatabase();
		DataManager.createDatabase();
		DataManager.insertOccupant(new Occupant("Justin","Hamilton",620153652,"(876)675-4534","Snailmail.@gmail.com","B2"));
		DataManager.insertOccupant(new Occupant("Jason","Smith",620153452,"(876)689-4534","jason.smith@gmail.com","B7"));
		DataManager.insertOccupant(new Occupant("Jackson","Miller",620153892,"(876)689-8934","jackson.smith@gmail.com","B7"));
		DataManager.updateOccupant(620153452, new Occupant("Jerry","Smith",620153452,"(876)689-4534","jason.smith@gmail.com","B7"));
		DataManager.insertFurniture(new Furniture("A1","Bed","Fair"));
		DataManager.insertFurniture(new Furniture("A2","Wall","Poor"));
		DataManager.updateFurniture(1, new Furniture("A1","Bed","Poor"));
		ArrayList<Furniture> f = DataManager.current_furniture("A2");
		ArrayList<Occupant> o = DataManager.current_Occupants("B7");
		for(Furniture f1:f) {
			System.out.println("Name:"+f1.getType()+" State:"+f1.getState()+" Room Id:"+f1.getRoom_id());
		}
		for(Occupant op:o){
			System.out.println("Name:"+op.getfName()+" "+op.getlName()
								+" Id Number:"+op.getIdNum()
								+" Phone Number:" + op.getPhoneNumber()
								+" Email:" + op.getEmail()
								+" Room_id:" + op.getRoom_id());
		}
	}	
}
