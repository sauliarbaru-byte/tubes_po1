package service;

import model.User;
import storage.UserStorage;

public class AuthService {

    public User login(String username, String password) {
        return UserStorage.findUser(username, password);
    }
}
