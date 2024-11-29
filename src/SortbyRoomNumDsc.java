import java.util.Comparator;
public class SortbyRoomNumDsc implements Comparator<Room>{
   //ascending 
    @Override
    public int compare(Room p1, Room p2){
    	 
            return p2.getRoomID().compareTo(p1.getRoomID());
    }   
}