import java.util.Comparator;

public class RSortByConditionD extends Room implements Comparator<Room>{

    @Override
    public int compare(Room r1, Room r2) {
        // TODO Auto-generated method stub
        return r1.getRoomScore()-r2.getRoomScore();
    }
    
    
}
