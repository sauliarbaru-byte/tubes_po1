package model;

import java.util.List;

public class DashboardSummary {

    private double ipk;
    private int totalSKS;
    private int streak;

    private List<String> jadwalHariIni;

    private int tugasHariIni;
    private int tugasBesok;
    private int tugasTerlambat;

    public DashboardSummary(
            double ipk,
            int totalSKS,
            int streak,
            List<String> jadwalHariIni,
            int tugasHariIni,
            int tugasBesok,
            int tugasTerlambat) {

        this.ipk = ipk;
        this.totalSKS = totalSKS;
        this.streak = streak;
        this.jadwalHariIni = jadwalHariIni;
        this.tugasHariIni = tugasHariIni;
        this.tugasBesok = tugasBesok;
        this.tugasTerlambat = tugasTerlambat;
    }

    public double getIpk() { return ipk; }
    public int getTotalSKS() { return totalSKS; }
    public int getStreak() { return streak; }
    public List<String> getJadwalHariIni() { return jadwalHariIni; }

    public int getTugasHariIni() { return tugasHariIni; }
    public int getTugasBesok() { return tugasBesok; }
    public int getTugasTerlambat() { return tugasTerlambat; }
}
