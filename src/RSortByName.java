import java.util.Comparator;

public class RSortByName extends Room implements Comparator<Room> {
    @Override
    public int compare(Room r1, Room r2) {
        // TODO Auto-generated method stub
        if ((r1.getRoomType() == "Single") && (r2.getRoomType() == "Single")) {
            Occupant o = r1.getOccupantLst().get(0);
            Occupant ot = r2.getOccupantLst().get(0); 
            return o.getlName().compareTo(ot.getlName());
        }
        else if ((r1.getRoomType() == "Double") && (r2.getRoomType() == "Single")) {
            Occupant o1 = r1.getOccupantLst().get(0);
            Occupant o2 = r1.getOccupantLst().get(1);
            Occupant ot = r2.getOccupantLst().get(0);
            return ot.getlName().compareTo(o1.getlName()+o2.getlName());
        }
        else if ((r1.getRoomType() == "Single") && (this.getRoomType() == "Double")) {
            Occupant o1 = r1.getOccupantLst().get(0);
            Occupant ot1 = r2.getOccupantLst().get(0);
            Occupant ot2 = r2.getOccupantLst().get(1);
            return o1.getlName().compareTo(ot1.getlName()+ot2.getlName());
        }
        else if ((r1.getRoomType() == "Double") && (this.getRoomType() == "Double")) {
            Occupant o1 = r1.getOccupantLst().get(0);
            Occupant o2 = r1.getOccupantLst().get(1);
            Occupant ot1 = r2.getOccupantLst().get(0);
            Occupant ot2 = r2.getOccupantLst().get(1);
            return (o1.getlName()+o2.getlName()).compareTo(ot1.getlName()+ot2.getlName());
        }
        else {
            return 0;
        }
    }

}