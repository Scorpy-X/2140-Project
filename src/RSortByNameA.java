import java.util.Comparator;

import javax.swing.JOptionPane;

public class RSortByNameA extends Room implements Comparator<Room> {
    @Override
    public int compare(Room r1, Room r2) {
        // TODO Auto-generated method stub
        if ((r1.getNumOccupants() == 0) && (r2.getNumOccupants() == 0)) {
            return " ".compareTo(" ");
        }
        else if ((r1.getNumOccupants() != 0) && (r2.getNumOccupants() != 0)){
            Occupant o1 = r1.getOccupantLst().get(0);
            Occupant o2 = r2.getOccupantLst().get(0);
            return o1.getlName().compareTo(o2.getlName());
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