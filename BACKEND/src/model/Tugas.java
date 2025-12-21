package model;

import java.time.LocalDateTime;

public class Tugas {

    private int mataKuliahId;
    private String judul;
    private String deskripsi;
    private LocalDateTime deadline;
    private String status;

    // ✅ Constructor kosong (penting untuk JavaFX dan Service)
    public Tugas() {}

    // ✅ Constructor lengkap (boleh dipakai di backend)
    public Tugas(int mataKuliahId, String judul, String deskripsi,
                 LocalDateTime deadline, String status) {
        this.mataKuliahId = mataKuliahId;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.deadline = deadline;
        this.status = status;
    }

    // ✅ Getter (pengambil nilai)
    public int getMataKuliahId() {
        return mataKuliahId;
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    // ✅ Setter (mengubah nilai)
    public void setMataKuliahId(int mataKuliahId) {
        this.mataKuliahId = mataKuliahId;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
