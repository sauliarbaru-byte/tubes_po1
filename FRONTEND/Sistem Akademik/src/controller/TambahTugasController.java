package controller;

import java.time.LocalDate;

import model.Tugas;
import repository.TugasRepository;
import view.TambahTugasView;

public class TambahTugasController {

    private TugasRepository tugasRepository;
    private TambahTugasView view;

    // constructor untuk View
    public TambahTugasController(TambahTugasView view) {
        this.view = view;
        this.tugasRepository = new TugasRepository();
    }

    // constructor default (aman)
    public TambahTugasController() {
        this.tugasRepository = new TugasRepository();
    }

    public void tambahTugas(
            String nim,
            String judul,
            LocalDate deadline,
            String priority
    ) {
        Tugas tugas = new Tugas();
        tugas.setNim(nim);
        tugas.setJudul(judul);
        tugas.setDeadline(deadline);
        tugas.setStatus("Belum");
        tugas.setPriority(priority);

        tugasRepository.insert(tugas);
    }
}
