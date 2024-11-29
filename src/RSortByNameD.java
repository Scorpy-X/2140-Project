import java.util.Comparator;

public class RSortByNameD extends Room implements Comparator<Room> {
    public int compare(Room r1, Room r2) {
        // TODO Auto-generated method stub
        if ((r1.getNumOccupants() == 0) && (r2.getNumOccupants() == 0)) {
            return " ".compareTo(" ");
        }
        else if ((r1.getNumOccupants() != 0) && (r2.getNumOccupants() != 0)){
            Occupant o1 = r1.getOccupantLst().get(0);
            Occupant o2 = r2.getOccupantLst().get(0);
            return o2.getlName().compareTo(o1.getlName());
        }
        else if ((r1.getNumOccupants() != 0) && (r2.getNumOccupants() == 0)){
            Occupant o1 = r1.getOccupantLst().get(0);
            return " ".compareTo(o1.getlName());
        }
        else {
            return 0;
        }
    }
}
