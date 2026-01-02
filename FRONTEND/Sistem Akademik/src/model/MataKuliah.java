package model;

public class MataKuliah {
    private String nama;
    private int sks;
    private String dosen;
    private String nilaiHuruf;

    // 🔹 UNTUK JADWAL
    public MataKuliah(String nama, int sks, String dosen) {
        this.nama = nama;
        this.sks = sks;
        this.dosen = dosen;
        this.nilaiHuruf = "-";
    }

    // 🔹 UNTUK NILAI / IPK
    public MataKuliah(String nama, int sks, String dosen, String nilaiHuruf) {
        this.nama = nama;
        this.sks = sks;
        this.dosen = dosen;
        this.nilaiHuruf = nilaiHuruf;
    }

    public String getNama() {
        return nama;
    }

    public int getSks() {
        return sks;
    }

    public String getDosen() {
        return dosen;
    }

    public String getNilaiHuruf() {
        return nilaiHuruf;
    }
}
