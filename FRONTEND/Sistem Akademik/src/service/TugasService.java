package service;

import model.Tugas;
import repository.TugasRepository;

public class TugasService {

    private TugasRepository tugasRepository;

    public TugasService() {
        tugasRepository = new TugasRepository();
    }

    public void tambahTugas(Tugas tugas) {
        tugasRepository.tambahTugas(tugas);
    }
}
