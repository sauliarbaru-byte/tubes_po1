package model;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Jadwal {
    private DayOfWeek hari;
    private LocalTime jamMulai;
    private LocalTime jamSelesai;
    private MataKuliah mataKuliah;

    public Jadwal(DayOfWeek hari, LocalTime jamMulai, LocalTime jamSelesai, MataKuliah mataKuliah) {
        this.hari = hari;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.mataKuliah = mataKuliah;
    }

    public DayOfWeek getHari() {
        return hari;
    }

    public LocalTime getJamMulai() {
        return jamMulai;
    }

    public LocalTime getJamSelesai() {
        return jamSelesai;
    }

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }
}
