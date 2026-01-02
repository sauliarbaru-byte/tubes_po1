package service;

import model.DashboardSummary;
import model.Jadwal;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DashboardService {

    private IPKService ipkService;
    private AbsensiService absensiService;
    private JadwalService jadwalService;
    private TugasService tugasService;

    public DashboardService(
            IPKService ipkService,
            AbsensiService absensiService,
            JadwalService jadwalService,
            TugasService tugasService) {

        this.ipkService = ipkService;
        this.absensiService = absensiService;
        this.jadwalService = jadwalService;
        this.tugasService = tugasService;
    }

    public DashboardSummary buildDashboard(User user) {

        double ipk = user.getIpk();
        int totalSKS = user.getTotalSks();
        int streak = absensiService.hitungStreak();

        // 👉 konversi Jadwal → String
        List<String> jadwalHariIni = new ArrayList<>();
        for (Jadwal j : jadwalService.getJadwalHariIni()) {
            jadwalHariIni.add(
                j.getMataKuliah().getNama() +
                " (" + j.getJamMulai() + " - " + j.getJamSelesai() + ")"
            );
        }

        int tugasHariIni = tugasService.hitungDeadlineHariIni();
        int tugasBesok = tugasService.hitungDeadlineBesok();
        int tugasTerlambat = tugasService.hitungTerlambat();

        return new DashboardSummary(
                ipk,
                totalSKS,
                streak,
                jadwalHariIni,
                tugasHariIni,
                tugasBesok,
                tugasTerlambat
        );
    }
}
