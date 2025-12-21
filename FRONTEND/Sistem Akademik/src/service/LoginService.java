package service;

import model.User;
import repository.UserRepository;

public class LoginService {

    private UserRepository repository;

    public LoginService() {
        repository = new UserRepository();
    }

    public User login(String email, String password) {
        return repository.login(email, password);
    }
}
