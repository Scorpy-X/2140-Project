import java.util.Comparator;
public class SortbyFirstNameDsc implements Comparator<Occupant>{
   //descending 
    @Override
    public int compare(Occupant p1, Occupant p2){
    	 
            return p2.getfName().compareTo(p1.getfName());
    }   
}



