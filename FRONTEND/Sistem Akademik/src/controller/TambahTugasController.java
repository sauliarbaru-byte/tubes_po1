package controller;

import model.Tugas;
import repository.TugasRepository;

public class TambahTugasController {

    private TugasRepository tugasRepository;

    public TambahTugasController() {
        tugasRepository = new TugasRepository();
    }

    public void tambahTugas(
            String nim,
            String judul,
            String deadline,
            String priority
    ) {
        Tugas tugas = new Tugas();
        tugas.setNim(nim);
        tugas.setJudul(judul);
        tugas.setDeadline(java.time.LocalDate.parse(deadline));
        tugas.setStatus("Belum");
        tugas.setPriority(priority);

        tugasRepository.insert(tugas);
    }
}
