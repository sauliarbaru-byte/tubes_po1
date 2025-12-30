package controller;

import model.User;
import service.LoginService;
import util.Session;
import view.DashboardView;
import view.LoginView;

import javax.swing.*;

public class LoginController {

    private LoginView view;
    private LoginService loginService;

    public LoginController(LoginView view) {
        this.view = view;
        this.loginService = new LoginService();
        initController();
    }

    private void initController() {
        view.getBtnLogin().addActionListener(e -> login());
    }

    private void login() {
    String username = view.getUsername().trim();
    String password = view.getPassword().trim();

    System.out.println("LOGIN DITEKAN");
    System.out.println("Username: " + username);
    System.out.println("Password: " + password);

    User user = loginService.login(username, password);

    System.out.println("User hasil login: " + user);

    if (user != null) {

        System.out.println("LOGIN BERHASIL");

        Session.setUser(username, username);

        DashboardView dashboard = new DashboardView(user);
        dashboard.setVisible(true);
        view.dispose();

    } else {
        JOptionPane.showMessageDialog(view, "Username atau password salah!");
    }
}
}
