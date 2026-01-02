package storage;

import model.Absensi;
import java.util.ArrayList;
import java.util.List;

public class AbsensiStorage {

    private static List<Absensi> dataAbsensi = new ArrayList<>();

    public static void tambah(Absensi absensi) {
        dataAbsensi.add(absensi);
    }

    public static List<Absensi> getSemua() {
        return dataAbsensi;
    }
}
