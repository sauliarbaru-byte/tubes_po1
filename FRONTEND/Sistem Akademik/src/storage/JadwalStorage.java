package storage;

import model.Jadwal;
import model.MataKuliah;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class JadwalStorage {

    private static List<Jadwal> jadwalList = new ArrayList<>();

    static {
        MataKuliah sd = new MataKuliah("Struktur Data", 3, "Pak Yulison");
        MataKuliah pw = new MataKuliah("Pemrograman Web", 3, "Pak Fatan");
        MataKuliah md = new MataKuliah("Matematika Diskrit", 3, "Pak Gunawan");

        jadwalList.add(new Jadwal(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(9, 40), sd));
        jadwalList.add(new Jadwal(DayOfWeek.WEDNESDAY, LocalTime.of(10, 0), LocalTime.of(11, 40), pw));
        jadwalList.add(new Jadwal(DayOfWeek.FRIDAY, LocalTime.of(13, 0), LocalTime.of(14, 40), md));
    }

    public static List<Jadwal> getAll() {
        return jadwalList;
    }
}
