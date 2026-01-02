package storage;

import model.Tugas;
import java.util.ArrayList;
import java.util.List;

public class TugasStorage {

    private static List<Tugas> daftarTugas = new ArrayList<>();

    public static void tambah(Tugas tugas) {
        daftarTugas.add(tugas);
    }

    public static List<Tugas> getSemua() {
        return daftarTugas;
    }
}
