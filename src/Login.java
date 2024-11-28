import java.util.HashMap;

public class Login{
    
    // Static map to store usernames and passwords
    private static HashMap<String, String> users = new HashMap<>();
    
    // Static block to initialize the user data (hardcoded for simplicity)
    static {
        // Adding some example users to the static map
        users.put("user1", "password123");
        users.put("user2", "password321");
        users.put("admin", "adminPass");
    }


    // Static method to validate login
    public static int validateLogin(String username, String password){
        
        // Check if username exists
        if (users.containsKey(username)) 
        {   

            //Checks if administration is signing in
            if(username.equals("admin") && users.get(username).equals(password)){

                return 2;
            }
            
            //Checks if it is student worker or secretary signing in
            else if(users.get(username).equals(password))
            {
                return 1;
            }

        }

        //user not authorized, invalid credentials 
        return 0;
    }

    
}
