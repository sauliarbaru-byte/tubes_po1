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

        loadSemuaTugas();

        view.getBtnTambahTugas().addActionListener(e ->
                new TambahTugasView(view).setVisible(true)
        );

        view.getBtnPriority().addActionListener(e -> {
            String[] options = {"HIGH", "MEDIUM", "LOW"};
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
                List<Tugas> hasil = tugasService.getByPriority(pilihan);
                view.tampilkanTugas(hasil);
            }
        });

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
                        hasil = tugasService.getDeadlineHariIni();
                        break;
                    case "BESOK":
                        hasil = tugasService.getDeadlineBesok();
                        break;
                    default:
                        hasil = tugasService.getTanpaDeadline();
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
