
package main;

import controller.*;
import model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ================= LOGIN =================
        LoginController loginController = new LoginController();

        System.out.print("Username: ");
        String user = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        User loggedIn = loginController.login(user, pass);

        if (loggedIn == null) {
            System.out.println("❌ LOGIN GAGAL");
            return;
        }

        System.out.println("✅ LOGIN BERHASIL");

        // ============== CONTROLLERS ==============
        AbsensiController absensiController = new AbsensiController();
        JadwalController jadwalController = new JadwalController();
        TugasController tugasController = new TugasController();
        NilaiController nilaiController = new NilaiController();
        IPKController ipkController = new IPKController();

        // ================= MENU ==================
        System.out.println("\n=== MENU ===");
        System.out.println("1. Jadwal Hari Ini");
        System.out.println("2. Jadwal Mingguan");
        System.out.println("3. Check-in Absensi");
        System.out.println("4. Tandai Tidak Hadir");
        System.out.println("5. Input Nilai Mata Kuliah");
        System.out.println("6. Lihat IPS & IPK");
        System.out.println("7. Tambah Tugas");
        System.out.println("8. Reminder Tugas");
        System.out.println("9. Tambah IPK Semester");
        System.out.println("0. Keluar");

        System.out.print("Pilih: ");
        int pilih = sc.nextInt();

        // ================= SWITCH =================
        switch (pilih) {
            case 1:
                jadwalController.tampilkanJadwalHariIni();
                break;
            case 2:
                jadwalController.tampilkanJadwalMingguan();
                break;
            case 3:
                absensiController.checkIn();
                break;
            case 4:
                absensiController.tambahTidakHadir();
                break;
            case 5:
                nilaiController.inputNilai();
                break;
            case 6:
                nilaiController.tampilkanIPK();
                break;
            case 7:
                tugasController.tambahTugas();
                break;
            case 8:
                tugasController.tampilkanReminder();
                break;
            case 9:
                ipkController.tambahIPK();
                break;
            case 0:
                System.out.println("👋 Keluar...");
                break;
            default:
                System.out.println("❌ Pilihan tidak valid");
        }

        sc.close();
    }
}
