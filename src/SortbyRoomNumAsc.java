import java.util.Comparator;
public class SortbyRoomNumAsc implements Comparator<Room>{
   //ascending 
    @Override
    public int compare(Room p1, Room p2){
    	 
            return p1.getRoomID().compareTo(p2.getRoomID());
    }   
}