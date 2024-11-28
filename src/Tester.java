public class Tester{

    public Tester(){}
public static void main(String[] args) {
        // Example login attempts
        System.out.println("Login attempt 1: " + Login.validateLogin("user1", "password123")); // Should return 1 (success)
        System.out.println("Login attempt 2: " + Login.validateLogin("user1", "wrongPassword")); // Should return 0 (wrong password)
        System.out.println("Login attempt 3: " + Login.validateLogin("unknownUser", "password123")); // Should return 0 (invalid username)
        System.out.println("Login attempt 4: " + Login.validateLogin("admin", "password123")); // Should return 0 (invalid password)
        System.out.println("Login attempt 5: " + Login.validateLogin("admin", "adminPass")); // Should return 2 (Admin privilage)
        
        TaylorAdmin TaylorHall = new TaylorAdmin(DataManager.loadData());
   
    }




}