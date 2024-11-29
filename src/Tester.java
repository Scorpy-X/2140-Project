import java.util.ArrayList;

public class Tester{

    public Tester(){}
public static void main(String[] args) {
        // Example login attempts
		
		TaylorAdmin th = new TaylorAdmin();
		Room r = th.findByRoomIdNum("C1");
		
		
		System.out.println(r.getNumOccupants());
		if(!r.addOccupant(new Occupant("Justin","Watts",620154652,"350-2999","jahwatts6@gmail.com")))
			System.out.println("here");
		if(!th.isValidIdNumber(620153652)) {
			System.out.println("Yup its here");
		}
		th.saveAllData();
        /*System.out.println("Login attempt 1: " + Login.validateLogin("user1", "password123")); // Should return 1 (success)
        System.out.println("Login attempt 2: " + Login.validateLogin("user1", "wrongPassword")); // Should return 0 (wrong password)
        System.out.println("Login attempt 3: " + Login.validateLogin("unknownUser", "password123")); // Should return 0 (invalid username)
        System.out.println("Login attempt 4: " + Login.validateLogin("admin", "password123")); // Should return 0 (invalid password)
        System.out.println("Login attempt 5: " + Login.validateLogin("admin", "adminPass")); // Should return 2 (Admin privilage)*/
}



}