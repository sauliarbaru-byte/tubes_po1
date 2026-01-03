package service;

import model.DashboardSummary;
import model.Jadwal;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DashboardService {

    private AbsensiService absensiService;
    private JadwalService jadwalService;
    private TugasService tugasService;

    public DashboardService(
            AbsensiService absensiService,
            JadwalService jadwalService,
            TugasService tugasService) {

        this.absensiService = absensiService;
        this.jadwalService = jadwalService;
        this.tugasService = tugasService;
    }

    public DashboardSummary buildDashboard(User user) {

        // ===== DATA USER =====
        double ipk = user.getIpk();
        int totalSKS = user.getTotalSks();

        // ===== ABSENSI (VERSI FRONTEND) =====
        // sementara: jumlah hadir hari ini
        int streak = absensiService.getJumlahHadir();

        // ===== JADWAL HARI INI =====
        List<String> jadwalHariIni = new ArrayList<>();
        for (Jadwal j : jadwalService.getJadwalHariIni()) {
            jadwalHariIni.add(
                    j.getMataKuliah().getNama() +
                    " (" + j.getJamMulai() + " - " + j.getJamSelesai() + ")"
            );
        }

        // ===== TUGAS =====
        int tugasHariIni = tugasService.hitungDeadlineHariIni();
        int tugasBesok = tugasService.hitungDeadlineBesok();
        int tugasTerlambat = tugasService.hitungTerlambat();

        // ===== SUMMARY =====
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
