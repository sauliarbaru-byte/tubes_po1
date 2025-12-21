package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginView() {
        setTitle("Login");
        setSize(350, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 229, 180));
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("Login");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(120, 30, 200, 30);
        panel.add(lblTitle);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(50, 80, 100, 20);
        panel.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(50, 100, 250, 35);
        panel.add(txtUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(50, 140, 100, 20);
        panel.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(50, 160, 250, 35);
        panel.add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(50, 220, 250, 40);
        panel.add(btnLogin);

        add(panel);

        new LoginController(this);
    }

    public String getUsername() {
        return txtUsername.getText();
    }

    public String getPassword() {
        return new String(txtPassword.getPassword());
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
    }    
}
