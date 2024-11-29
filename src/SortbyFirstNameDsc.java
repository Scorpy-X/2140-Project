import java.util.Comparator;
public class SortbyFirstNameDsc extends Occupant implements Comparator<Occupant>, Comparable<Occupant>{
   //descending 
    @Override
    public int compare(Occupant o1, Occupant o2){
    	 
            return o2.getfName().compareTo(o1.getfName());
    }

@Override
public int compareTo(Occupant o) {
        return o.getfName().compareTo(this.getfName());
}   
}



