package storage;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private static List<User> users = new ArrayList<>();

    static {
        // dummy user (sementara)
        User u = new User();
        u.setUsername("Kelompok8");
        u.setPassword("123");
        u.setIpk(3.75);
        u.setStreak(4);
        users.add(u);
    }

    public static User login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username)
                    && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
