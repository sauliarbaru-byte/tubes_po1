package controller;

import model.User;
import repository.UserRepository;
import util.Session;
import view.DashboardView;
import view.LoginView;

import javax.swing.*;

public class LoginController {

    Session.setUser(
    user.getId(),
    user.getUsername(),
    user.getRole()
);

    private LoginView view;
    private UserRepository userRepository;

    public LoginController(LoginView view) {
        this.view = view;
        this.userRepository = new UserRepository();
        initController();
    }

    private void initController() {
        view.getBtnLogin().addActionListener(e -> login());
    }

    private void login() {

        String username = view.getUsername().trim();
        String password = view.getPassword().trim();

        User user = userRepository.login(username, password);

        if (user != null) {

            DashboardView dashboard = new DashboardView(user);
            dashboard.setVisible(true);
            view.dispose();

        } else {
            JOptionPane.showMessageDialog(view, "Username atau password salah!");
        }
    }
}
