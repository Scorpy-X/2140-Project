public class Tester{


public static void main(String[] args) {
        // Example login attempts
        System.out.println("Login attempt 1: " + Login.validateLogin("user1", "password123")); // Should return 0 (success)
        System.out.println("Login attempt 2: " + Login.validateLogin("user1", "wrongPassword")); // Should return -2 (wrong password)
        System.out.println("Login attempt 3: " + Login.validateLogin("unknownUser", "password123")); // Should return -1 (invalid username)
    }



}