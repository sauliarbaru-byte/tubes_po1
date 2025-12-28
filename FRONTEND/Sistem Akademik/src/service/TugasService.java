package service;

import model.Tugas;
import repository.TugasRepository;

import java.util.List;

public class TugasService {

    private TugasRepository tugasRepository;

    public TugasService() {
        tugasRepository = new TugasRepository();
    }

    // ======================
    // TAMBAH TUGAS
    // ======================
    public void tambahTugas(Tugas tugas) {
        if (tugas.getStatus() == null) {
            tugas.setStatus("BELUM SELESAI");
        }
        tugasRepository.tambahTugas(tugas);
    }

    // ======================
    // AMBIL SEMUA TUGAS
    // ======================
    public List<Tugas> getAllTugas() {
        return tugasRepository.getAllTugas();
    }

    // ======================
    // FILTER (sementara pakai STATUS)
    // ======================
    public List<Tugas> getTugasByPriority(String status) {
        return tugasRepository.findByPriority(status);
    }

    public List<Tugas> getTugasHariIni() {
        return tugasRepository.findDeadlineHariIni();
    }

    public List<Tugas> getTugasBesok() {
        return tugasRepository.findDeadlineBesok();
    }

    public List<Tugas> getTugasTanpaDeadline() {
        return tugasRepository.findTanpaDeadline();
    }

    // ======================
    // UPDATE STATUS
    // ======================
    public void tandaiSelesai(int id) {
        tugasRepository.updateStatusSelesai(id);
    }
}
