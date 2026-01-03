package model;

import java.time.LocalDate;

public class Tugas {
    private String nama;
    private String mataKuliah;
    private LocalDate deadline;

    // ===== TAMBAHAN =====
    private boolean selesai = false;

    public Tugas(String nama, String mataKuliah, LocalDate deadline) {
        this.nama = nama;
        this.mataKuliah = mataKuliah;
        this.deadline = deadline;
    }

    public String getNama() {
        return nama;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    // ===== TAMBAHAN =====
    public boolean isSelesai() {
        return selesai;
    }

    public void toggleSelesai() {
        this.selesai = !this.selesai;
    }
}
