package service;

import model.Jadwal;
import storage.JadwalStorage;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JadwalService {

    public List<Jadwal> getJadwalHariIni() {
        DayOfWeek hariIni = LocalDate.now().getDayOfWeek();
        List<Jadwal> hasil = new ArrayList<>();

        for (Jadwal j : JadwalStorage.getAll()) {
            if (j.getHari() == hariIni) {
                hasil.add(j);
            }
        }
        return hasil;
    }

    public List<Jadwal> getJadwalMingguan() {
        return JadwalStorage.getAll();
    }
}
