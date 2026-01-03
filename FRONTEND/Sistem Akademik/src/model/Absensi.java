package model;

public class Absensi {

    private String mataKuliah;
    private String jam;
    private boolean hadir;

    public Absensi(String mataKuliah, String jam) {
        this.mataKuliah = mataKuliah;
        this.jam = jam;
        this.hadir = false;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public String getJam() {
        return jam;
    }

    public boolean isHadir() {
        return hadir;
    }

    public void toggleHadir() {
        this.hadir = !this.hadir;
    }
}
