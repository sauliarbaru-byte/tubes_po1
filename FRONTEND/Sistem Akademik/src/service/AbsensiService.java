package service;

import model.Absensi;
import java.util.ArrayList;
import java.util.List;

public class AbsensiService {

    private static AbsensiService instance;
    private final List<Absensi> daftarAbsensi = new ArrayList<>();

    private AbsensiService() {
        // dummy data (hari ini)
        daftarAbsensi.add(new Absensi("Pemrograman Objek", "08.00"));
        daftarAbsensi.add(new Absensi("Basis Data", "10.00"));
        daftarAbsensi.add(new Absensi("Jaringan Komputer", "13.00"));
    }

    public static AbsensiService getInstance() {
        if (instance == null) {
            instance = new AbsensiService();
        }
        return instance;
    }

    public List<Absensi> getAbsensiHariIni() {
        return daftarAbsensi;
    }

    public int getTotal() {
        return daftarAbsensi.size();
    }

    public int getJumlahHadir() {
        int count = 0;
        for (Absensi a : daftarAbsensi) {
            if (a.isHadir()) count++;
        }
        return count;
    }
}
