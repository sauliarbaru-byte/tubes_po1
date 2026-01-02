package storage;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("arya", "123"));
    }

    public static User findUser(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username)
             && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
