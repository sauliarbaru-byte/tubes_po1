package controller;

import model.Tugas;
import service.TugasService;
import util.Session;
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

        loadSemuaTugasUserLogin();

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
                view.tampilkanTugas(
                        tugasService.getByPriorityUser(Session.getUserId(), pilihan)
                );
            }
        });
    }

    private void loadSemuaTugasUserLogin() {
        int userId = Session.getUserId();
        List<Tugas> list = tugasService.getAllByUser(userId);
        view.tampilkanTugas(list);
    }
}
