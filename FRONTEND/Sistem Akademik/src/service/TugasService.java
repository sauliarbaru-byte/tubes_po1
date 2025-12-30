package service;

import model.Tugas;
import storage.TugasStorage;

import java.util.List;
import java.util.stream.Collectors;

public class TugasService {

    private TugasStorage storage = TugasStorage.getInstance();

    public List<Tugas> getAllTugas() {
        return storage.getAll();
    }

    public List<Tugas> getByPriority(String priority) {
        return storage.getAll()
                .stream()
                .filter(t -> t.getPriority().equalsIgnoreCase(priority))
                .collect(Collectors.toList());
    }

    public void tambahTugas(Tugas tugas) {
        storage.add(tugas);
    }

    // ================= DASHBOARD COMPATIBILITY =================

public List<Tugas> getDeadlineHariIni() {
    return storage.getAll()
            .stream()
            .filter(t -> t.getDeadline() != null)
            .limit(3) // dummy dulu
            .toList();
}

public List<Tugas> getDeadlineBesok() {
    return storage.getAll()
            .stream()
            .filter(t -> t.getDeadline() != null)
            .limit(3)
            .toList();
}

public List<Tugas> getTanpaDeadline() {
    return storage.getAll()
            .stream()
            .filter(t -> t.getDeadline() == null)
            .toList();
}

}
