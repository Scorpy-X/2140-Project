import java.util.Comparator;
public class SortbyFirstNameAsc implements Comparator<Occupant>{
   //ascending 
    @Override
    public int compare(Occupant p1, Occupant p2){
    	 
            return p1.getfName().compareTo(p2.getfName());
    }   
}