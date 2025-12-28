package view;

import model.Tugas;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DashboardView extends JFrame {

    private JButton btnPriority;
    private JButton btnDeadline;
    private JButton btnTambahTugas;
    private JPanel panelTugas;
    private JScrollPane scrollTugas;
    private User user;
    private JPanel panel;

    public DashboardView(User user) {
        this.user = user;
        initComponents();
    }

    private void initComponents() {
        setTitle("Dashboard");
        setSize(360, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ✅ GUNAKAN panel FIELD
        panel = new JPanel(null);
        panel.setBackground(new Color(255, 229, 180));

        // ===== INFO BOX =====
        panel.add(createBox("🔥 Streak", user.getStreak(), 20));
        panel.add(createBox("📈 IPK", user.getIpk(), 100));
        panel.add(createBox("✔ Today", user.getToday(), 180));
        panel.add(createBox("⭐ Level", user.getLevel(), 260));

        // ===== BUTTON FILTER =====
        btnPriority = new JButton("Priority");
        btnPriority.setBounds(40, 160, 120, 35);
        panel.add(btnPriority);

        btnDeadline = new JButton("Deadline");
        btnDeadline.setBounds(180, 160, 120, 35);
        panel.add(btnDeadline);

        // ===== BUTTON TAMBAH TASK =====
        btnTambahTugas = new JButton("+ Task");
        btnTambahTugas.setBounds(120, 200, 120, 30);
        panel.add(btnTambahTugas);

        // ===== PANEL TUGAS =====
        panelTugas = new JPanel();
        panelTugas.setLayout(new BoxLayout(panelTugas, BoxLayout.Y_AXIS));
        panelTugas.setBackground(new Color(255, 245, 220));

        scrollTugas = new JScrollPane(panelTugas);
        scrollTugas.setBounds(20, 240, 300, 340);
        scrollTugas.setBorder(BorderFactory.createTitledBorder("📌 Tasks"));

        panel.add(scrollTugas);

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

    // ===== DIPANGGIL CONTROLLER =====
    public void tampilkanTugas(List<Tugas> list) {
        panelTugas.removeAll();

        if (list.isEmpty()) {
            panelTugas.add(new JLabel("Tidak ada tugas"));
        } else {
            for (Tugas t : list) {
                JPanel item = new JPanel(new BorderLayout());
                item.setMaximumSize(new Dimension(280, 60));
                item.setBackground(new Color(230, 215, 180));
                item.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                JLabel lblJudul = new JLabel("📘 " + t.getJudul());
                JLabel lblInfo = new JLabel(
                        "<html><small>Deadline: " + t.getDeadline()
                                + "<br>Status: " + t.getStatus()
                                + "</small></html>"
                );

                item.add(lblJudul, BorderLayout.NORTH);
                item.add(lblInfo, BorderLayout.CENTER);

                panelTugas.add(item);
                panelTugas.add(Box.createVerticalStrut(8));
            }
        }

        panelTugas.revalidate();
        panelTugas.repaint();
    }

    // ===== GETTER =====
    public JButton getBtnTambahTugas() {
        return btnTambahTugas;
    }

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
