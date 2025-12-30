package model;

import java.time.LocalDate;

public class Tugas {

    private String nim;
    private String judul;
    private LocalDate deadline;
    private String status;
    private String priority;

    public Tugas() {
    }

    public Tugas(String judul, String priority) {
        this.judul = judul;
        this.priority = priority;
        this.status = "Belum Selesai";
    }

    // ===== GETTER =====
    public String getNim() {
        return nim;
    }

    public String getJudul() {
        return judul;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    // ===== SETTER =====
    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
