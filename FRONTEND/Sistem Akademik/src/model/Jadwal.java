package model;

public class Jadwal {

    private int id;
    private int mataKuliahId;
    private String hari;
    private String jam;

    public Jadwal(int id, int mataKuliahId, String hari, String jam) {
        this.id = id;
        this.mataKuliahId = mataKuliahId;
        this.hari = hari;
        this.jam = jam;
    }

    public int getId() {
        return id;
    }

    public int getMataKuliahId() {
        return mataKuliahId;
    }

    public String getHari() {
        return hari;
    }

    public String getJam() {
        return jam;
    }
}
