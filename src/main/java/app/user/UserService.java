package app.user;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 2017-03-18.
 */
public class UserService {

    private List<User> users;


    public UserService() {
        users = new ArrayList<>();

        // dummy values
        User u1 = new User("David", "1234");
        users.add(u1);

        User u2 = new User("Cowan", "password");
        users.add(u2);
    }

    public Iterable<User> getUsers() {return users;}

    public User getUser(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    public boolean addUser(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return false;
            }
        }
        User user = new User();
        user.setUsername(username);
        user.setHashedpassword("password");
        users.add(user);
        return true;
    }
}
