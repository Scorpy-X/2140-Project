
import java.util.Comparator;
//descending
public class SortbyLastNameDsc implements Comparator<Occupant>{
   
    @Override
    public int compare(Occupant p1, Occupant p2){
    	 
            return p2.getlName().compareTo(p1.getlName());
    }   
}
