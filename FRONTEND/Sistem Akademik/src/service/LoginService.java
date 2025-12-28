package service;

import model.User;
import repository.UserRepository;

public class LoginService {

    private UserRepository userRepository;

    public LoginService() {
        userRepository = new UserRepository();
    }

    public User login(String username, String password) {
        return userRepository.login(username, password);
    }
}
