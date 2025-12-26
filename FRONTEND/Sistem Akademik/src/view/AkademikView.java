package view;

import model.Akademik;

import javax.swing.*;
import java.awt.*;

public class AkademikView extends JFrame {

    public AkademikView(Akademik akademik) {
        setTitle("Akademik");
        setSize(350, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 231, 194));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("<-- Akademik");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(title);
        panel.add(Box.createVerticalStrut(15));

        panel.add(createField("Program", akademik.getProgram()));
        panel.add(createField("Jenjang", akademik.getJenjang()));
        panel.add(createField("Prodi", akademik.getProdi()));
        panel.add(createField("Tanggal Masuk", akademik.getTanggalMasuk()));

        JPanel angkatanPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        angkatanPanel.setOpaque(false);

        angkatanPanel.add(createSmallField("Angkatan", akademik.getAngkatan()));
        angkatanPanel.add(createSmallField("Semester", akademik.getSemester()));

        panel.add(Box.createVerticalStrut(10));
        panel.add(angkatanPanel);

        add(panel);
    }

    private JPanel createField(String labelText, String value) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel(labelText);
        JTextField field = new JTextField(value);
        field.setEditable(false);
        field.setBackground(new Color(210, 180, 140));
        field.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        panel.add(label);
        panel.add(field);
        panel.add(Box.createVerticalStrut(10));

        return panel;
    }

    private JPanel createSmallField(String labelText, String value) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel(labelText);
        JTextField field = new JTextField(value);
        field.setEditable(false);
        field.setBackground(new Color(210, 180, 140));

        panel.add(label);
        panel.add(field);

        return panel;
    }
}
