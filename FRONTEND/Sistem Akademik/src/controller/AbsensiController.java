package controller;

import model.Absensi;
import service.AbsensiService;
import storage.AbsensiStorage;

import java.time.LocalDate;
import java.util.Scanner;

public class AbsensiController {

    private AbsensiService service = new AbsensiService();

    public void checkIn() {
        AbsensiStorage.tambah(new Absensi(LocalDate.now(), true));
        System.out.println("✅ Check-in berhasil (" + LocalDate.now() + ")");
    }

    public void tambahTidakHadir() {
        AbsensiStorage.tambah(new Absensi(LocalDate.now(), false));
        System.out.println("❌ Absensi tidak hadir dicatat");
    }

    public void tampilkanGrafikTeks() {
        System.out.println("\n📊 GRAFIK KEHADIRAN");

        int hadir = service.totalHadir();
        int tidak = service.totalTidakHadir();

        System.out.print("Hadir     : ");
        for (int i = 0; i < hadir; i++) System.out.print("█");
        System.out.println(" (" + hadir + ")");

        System.out.print("Tidak Hadir: ");
        for (int i = 0; i < tidak; i++) System.out.print("█");
        System.out.println(" (" + tidak + ")");

        System.out.printf("\n📈 Persentase Kehadiran: %.2f%%\n",
                service.persentaseKehadiran());

        System.out.println("🔥 Streak Kehadiran: " + service.hitungStreak() + " hari");
    }
}
