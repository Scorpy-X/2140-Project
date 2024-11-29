import java.util.Comparator;

public class RSortByConditionA extends Room implements Comparator<Room>{

    @Override
    public int compare(Room r1, Room r2) {
        // TODO Auto-generated method stub
        return r2.getRoomScore()-r1.getRoomScore();
    }
    
    
}
