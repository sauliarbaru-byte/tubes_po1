package view;

import model.User;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JFrame {

    private JButton btnPriority;
    private JButton btnDeadline;
    private User user; // simpan user

    public DashboardView(User user) {
        this.user = user;
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Dashboard");
        setSize(360, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(255, 229, 180));

        btnPriority = new JButton("Priority");
        btnPriority.setBounds(40, 160, 120, 35);
        panel.add(btnPriority);

        btnDeadline = new JButton("Deadline");
        btnDeadline.setBounds(180, 160, 120, 35);
        panel.add(btnDeadline);

        panel.add(createBox("🔥 Streak", user.getStreak(), 20));
        panel.add(createBox("📈 IPK", user.getIpk(), 100));
        panel.add(createBox("✔ Today", user.getToday(), 180));
        panel.add(createBox("⭐ Level", user.getLevel(), 260));

        add(panel);

        // HUBUNGKAN CONTROLLER
        new controller.DashboardController(this);
    }

    private JLabel createBox(String title, Object value, int x) {
        JLabel label = new JLabel(
                "<html><center>" + title + "<br>" + value + "</center></html>",
                SwingConstants.CENTER
        );
        label.setOpaque(true);
        label.setBackground(new Color(210, 190, 150));
        label.setBounds(x, 80, 70, 60);
        return label;
    }

    // ===== GETTER UNTUK CONTROLLER =====
    public JButton getBtnPriority() {
        return btnPriority;
    }

    public JButton getBtnDeadline() {
        return btnDeadline;
    }

    public User getUser() {
        return user;
    }
}
