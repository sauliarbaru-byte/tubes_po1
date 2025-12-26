package model;

public class MataKuliah {

    private int id;
    private String nama;

    public MataKuliah(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
}
