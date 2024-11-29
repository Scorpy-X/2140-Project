import java.util.Comparator;
public class SortbyFirstNameDsc extends Occupant implements Comparator<Occupant>{
   //descending 
    @Override
    public int compare(Occupant o1, Occupant o2){
            return o2.getfName().compareTo(o1.getfName());
    }
}
