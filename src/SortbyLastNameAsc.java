import java.util.Comparator;
//Ascending
public class SortbyLastNameAsc extends Occupant implements Comparator<Occupant>{
   
    @Override
    public int compare(Occupant o1, Occupant o2){
    	 
            return o1.getlName().compareTo(o2.getlName());
    }   
}

