package controller;

import model.Tugas;
import service.TugasService;
import view.TambahTugasView;

import javax.swing.*;
import java.time.LocalDateTime;

public class TambahTugasController {

    private TambahTugasView view;
    private TugasService service;

    public TambahTugasController(TambahTugasView view) {
        this.view = view;
        this.service = new TugasService();

        view.getBtnSimpan().addActionListener(e -> simpan());
    }

    private void simpan() {
        try {
            Tugas t = new Tugas();
            t.setMataKuliahId(1); // sementara
            t.setJudul(view.getTxtJudul().getText());
            t.setDeskripsi(view.getTxtDeskripsi().getText());
            t.setDeadline(LocalDateTime.parse(
                    view.getTxtDeadline().getText().replace(" ", "T")
            ));
            t.setStatus(view.getCmbStatus().getSelectedItem().toString());

            service.tambahTugas(t);

            JOptionPane.showMessageDialog(view, "Tugas berhasil disimpan!");
            view.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Input tidak valid!");
        }
    }
}
