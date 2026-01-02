package controller;

import model.Jadwal;
import service.JadwalService;

import java.util.List;

public class JadwalController {

    private JadwalService service = new JadwalService();

    public void tampilkanJadwalHariIni() {
        List<Jadwal> jadwal = service.getJadwalHariIni();

        System.out.println("\n📅 Jadwal Hari Ini");
        if (jadwal.isEmpty()) {
            System.out.println("Tidak ada jadwal hari ini.");
            return;
        }

        for (Jadwal j : jadwal) {
            System.out.println(j.getJamMulai() + " - " +
                    j.getJamSelesai() + " | " +
                    j.getMataKuliah().getNama() +
                    " (" + j.getMataKuliah().getDosen() + ")");
        }
    }

    public void tampilkanJadwalMingguan() {
        List<Jadwal> jadwal = service.getJadwalMingguan();

        System.out.println("\n📆 Jadwal Mingguan");
        for (Jadwal j : jadwal) {
            System.out.println(j.getHari() + " | " +
                    j.getJamMulai() + "-" + j.getJamSelesai() + " | " +
                    j.getMataKuliah().getNama());
        }
    }
}
