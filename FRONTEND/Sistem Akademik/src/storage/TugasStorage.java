package storage;

import model.Tugas;
import java.util.ArrayList;
import java.util.List;

public class TugasStorage {

    private static TugasStorage instance;
    private List<Tugas> daftarTugas;

    private TugasStorage() {
        daftarTugas = new ArrayList<>();

        // DATA CONTOH
        daftarTugas.add(new Tugas("Tugas Kalkulus", "High"));
        daftarTugas.add(new Tugas("Laporan PBO", "Medium"));
        daftarTugas.add(new Tugas("Resume Jurnal", "Low"));
    }

    public static TugasStorage getInstance() {
        if (instance == null) {
            instance = new TugasStorage();
        }
        return instance;
    }

    public List<Tugas> getAll() {
        return daftarTugas;
    }

    public void add(Tugas tugas) {
        daftarTugas.add(tugas);
    }
}
