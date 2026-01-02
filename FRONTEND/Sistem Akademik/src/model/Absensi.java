package model;

import java.time.LocalDate;

public class Absensi {

    private LocalDate tanggal;
    private boolean hadir;

    public Absensi(LocalDate tanggal, boolean hadir) {
        this.tanggal = tanggal;
        this.hadir = hadir;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public boolean isHadir() {
        return hadir;
    }
}
