package service;

import java.util.List;

import model.Tugas;
import repository.TugasRepository;

public class TugasService {

    private TugasRepository repository = new TugasRepository();

    public void tambahTugas(Tugas tugas) {
        repository.insert(tugas);
    }
    

    public List<Tugas> getAllTugas() {
        return repository.getAllTugas();
    }

    public List<Tugas> getByPriority(String priority) {
        return repository.findByPriority(priority);
    }

    public List<Tugas> getDeadlineHariIni() {
        return repository.findDeadlineHariIni();
    }

    public List<Tugas> getDeadlineBesok() {
        return repository.findDeadlineBesok();
    }

    public List<Tugas> getTanpaDeadline() {
        return repository.findTanpaDeadline();
    }

    public List<Tugas> getAllTugasByNim(String nim) {
    return repository.findByNim(nim);
    }


    public void updateStatusSelesai(int idTugas) {
        repository.updateStatusSelesai(idTugas);
    }
}
