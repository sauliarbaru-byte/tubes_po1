package model;

public class Akademik {
    private String program;
    private String jenjang;
    private String prodi;
    private String tanggalMasuk;
    private String angkatan;
    private String semester;

    public Akademik(String program, String jenjang, String prodi,
                    String tanggalMasuk, String angkatan, String semester) {
        this.program = program;
        this.jenjang = jenjang;
        this.prodi = prodi;
        this.tanggalMasuk = tanggalMasuk;
        this.angkatan = angkatan;
        this.semester = semester;
    }

    public String getProgram() { return program; }
    public String getJenjang() { return jenjang; }
    public String getProdi() { return prodi; }
    public String getTanggalMasuk() { return tanggalMasuk; }
    public String getAngkatan() { return angkatan; }
    public String getSemester() { return semester; }
}
