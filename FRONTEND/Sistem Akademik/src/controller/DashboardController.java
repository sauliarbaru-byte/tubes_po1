package controller;

import model.Tugas;
import service.TugasService;
import view.DashboardView;
import view.TambahTugasView;

import javax.swing.*;
import java.util.List;

public class DashboardController {

    private DashboardView view;
    private TugasService tugasService;

    public DashboardController(DashboardView view) {
        this.view = view;
        this.tugasService = new TugasService();

        // ✅ LOAD SEMUA TUGAS SAAT DASHBOARD DIBUKA
        loadSemuaTugas();

        // ===== BUTTON TAMBAH TASK =====
        view.getBtnTambahTugas().addActionListener(e ->
                new TambahTugasView(view).setVisible(true)
        );

        // ===== FILTER PRIORITY =====
        view.getBtnPriority().addActionListener(e -> {
            String[] options = {"URGENT", "HIGH", "MEDIUM"};
            String pilihan = (String) JOptionPane.showInputDialog(
                    view,
                    "Pilih Priority",
                    "Filter Priority",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (pilihan != null) {
                List<Tugas> hasil = tugasService.getTugasByPriority(pilihan);
                view.tampilkanTugas(hasil);
            }
        });

        // ===== FILTER DEADLINE =====
        view.getBtnDeadline().addActionListener(e -> {
            String[] options = {"HARI_INI", "BESOK", "TANPA_DEADLINE"};
            String pilihan = (String) JOptionPane.showInputDialog(
                    view,
                    "Pilih Deadline",
                    "Filter Deadline",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (pilihan != null) {
                List<Tugas> hasil;

                switch (pilihan) {
                    case "HARI_INI":
                        hasil = tugasService.getTugasHariIni();
                        break;
                    case "BESOK":
                        hasil = tugasService.getTugasBesok();
                        break;
                    default:
                        hasil = tugasService.getTugasTanpaDeadline();
                        break;
                }

                view.tampilkanTugas(hasil);
            }
        });
    }

    private void loadSemuaTugas() {
        List<Tugas> list = tugasService.getAllTugas();
        view.tampilkanTugas(list);
    }
}
