package service;

import model.User;
import storage.UserStorage;

public class LoginService {

    public User login(String username, String password) {
        return UserStorage.login(username, password);
    }
}
