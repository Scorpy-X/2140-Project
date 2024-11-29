import java.util.Comparator;
//Ascending
public class SortbyLastNameAsc implements Comparator<Occupant>{
   
    @Override
    public int compare(Occupant p1, Occupant p2){
    	 
            return p1.getlName().compareTo(p2.getlName());
    }   
}

