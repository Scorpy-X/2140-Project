import java.util.ArrayList;


public class Main { //Small Demonstration of database methods 
	public static void main(String[] args) {
		DataManager.createDatabase();
		ArrayList<Block> b_lst = DataManager.loadData();
		
		for(Block b: b_lst){
			ArrayList<Room> r_lst = b.getRooms();
			
			for(Room r: r_lst){
				ArrayList<Furniture> f_lst = r.getFurnitureLst();
				ArrayList<Occupant> o_lst = r.getOccupantLst();
				int i = 0;
				if (o_lst != null) {
					for(Occupant o:o_lst) {
						if(o!=null)
							System.out.println(o.getfName());
					}
				}
				
				for(Furniture f: f_lst){
					System.out.println("In room: "+r.getRoomID()+" f"+i+"'s State: "+f.getState());
					i++;
				}
				
			}
			
		}
		DataManager.saveData(b_lst);
	}	
}
