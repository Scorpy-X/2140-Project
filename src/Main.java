import java.util.ArrayList;

public class Main { //Small Demonstration of database methods 
	public static void main(String[] args){
	DataManager.clearDatabase();
	DataManager.createDatabase();
	DataManager.insertFurniture(new Furniture("A1","Chair","Good"), "A1");
	DataManager.insertFurniture(new Furniture("A2","Wall","Poor"), "A2");
	ArrayList<Furniture> f = DataManager.current_furniture("A1");
	}
}

