package controller;

import model.User;
import repository.UserRepository;
import view.DashboardView;
import view.LoginView;

import javax.swing.*;

public class LoginController {

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
        // Ambil input dari LoginView dan hapus spasi di awal/akhir
        String username = view.getUsername().trim();
        String password = view.getPassword().trim();
    
        // Debug log sementara
        System.out.println("Username yang dikirim ke query: '" + username + "'");
        System.out.println("Password yang dikirim ke query: '" + password + "'");
    
        // Panggil repository untuk cek login
        User user = userRepository.login(username, password);
    
        if (user != null) {
            // Login berhasil → buka dashboard
            DashboardView dashboard = new DashboardView(user);
            dashboard.setVisible(true);
    
            // Tutup login
            view.dispose();
        } else {
            JOptionPane.showMessageDialog(view, "Username atau password salah!");
        }
    }
    
}
