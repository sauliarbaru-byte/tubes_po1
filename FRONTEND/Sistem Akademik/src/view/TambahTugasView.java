package view;

import javax.swing.*;
import java.awt.*;

public class TambahTugasView extends JFrame {

    private JTextField txtJudul;
    private JTextArea txtDeskripsi;
    private JTextField txtDeadline;
    private JComboBox<String> cmbStatus;
    private JButton btnSimpan;

    public TambahTugasView(DashboardView dashboardView) {
        initComponents();
        setLocationRelativeTo(dashboardView);
    }


    private void initComponents() {
        setTitle("Tambah Tugas");
        setSize(360, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(255, 229, 180));

        JLabel lblJudul = new JLabel("Judul");
        lblJudul.setBounds(20, 30, 100, 25);
        panel.add(lblJudul);

        txtJudul = new JTextField();
        txtJudul.setBounds(20, 55, 300, 30);
        panel.add(txtJudul);

        JLabel lblDesc = new JLabel("Deskripsi");
        lblDesc.setBounds(20, 95, 100, 25);
        panel.add(lblDesc);

        txtDeskripsi = new JTextArea();
        JScrollPane sp = new JScrollPane(txtDeskripsi);
        sp.setBounds(20, 120, 300, 80);
        panel.add(sp);

        JLabel lblDeadline = new JLabel("Deadline (YYYY-MM-DD HH:MM)");
        lblDeadline.setBounds(20, 210, 250, 25);
        panel.add(lblDeadline);

        txtDeadline = new JTextField();
        txtDeadline.setBounds(20, 235, 300, 30);
        panel.add(txtDeadline);

        JLabel lblStatus = new JLabel("Priority / Status");
        lblStatus.setBounds(20, 275, 150, 25);
        panel.add(lblStatus);

        cmbStatus = new JComboBox<>(new String[]{"LOW", "MEDIUM", "HIGH"});
        cmbStatus.setBounds(20, 300, 300, 30);
        panel.add(cmbStatus);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(100, 360, 150, 35);
        panel.add(btnSimpan);

        add(panel);

        new controller.TambahTugasController(this);
    }

    // ===== GETTER =====
    public JTextField getTxtJudul() {
        return txtJudul;
    }

    public JTextArea getTxtDeskripsi() {
        return txtDeskripsi;
    }

    public JTextField getTxtDeadline() {
        return txtDeadline;
    }

    public JComboBox<String> getCmbStatus() {
        return cmbStatus;
    }

    public JButton getBtnSimpan() {
        return btnSimpan;
    }
    
}
