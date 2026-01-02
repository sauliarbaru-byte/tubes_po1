package model;

public class IPKSemester {
    private int semester;
    private double ipk;

    public IPKSemester(int semester, double ipk) {
        this.semester = semester;
        this.ipk = ipk;
    }

    public int getSemester() {
        return semester;
    }

    public double getIpk() {
        return ipk;
    }
}
