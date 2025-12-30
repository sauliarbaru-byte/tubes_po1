package controller;

import java.time.LocalDate;

import model.Tugas;
import storage.TugasStorage;
import view.TambahTugasView;

public class TambahTugasController {

    private TugasStorage tugasStorage;
    private TambahTugasView view;

    
    public TambahTugasController(TambahTugasView view) {
        this.view = view;
        
    }

    
    public TambahTugasController() {
        
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

        
    }
}
