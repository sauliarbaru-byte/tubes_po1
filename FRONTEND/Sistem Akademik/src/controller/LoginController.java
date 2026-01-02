package controller;

import model.User;
import service.AuthService;

public class LoginController {
    private AuthService authService = new AuthService();

    public User login(String username, String password) {
        return authService.login(username, password);
    }
}
