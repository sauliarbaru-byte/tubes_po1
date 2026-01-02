package controller;

import model.Tugas;
import service.TugasService;
import storage.TugasStorage;

import java.time.LocalDate;
import java.util.Scanner;

public class TugasController {

    private TugasService service = new TugasService();

    public void tambahTugas() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nama Tugas: ");
        String nama = sc.nextLine();

        System.out.print("Mata Kuliah: ");
        String mk = sc.nextLine();

        System.out.print("Deadline (yyyy-mm-dd): ");
        LocalDate deadline = LocalDate.parse(sc.nextLine());

        TugasStorage.tambah(new Tugas(nama, mk, deadline));
        System.out.println("✅ Tugas berhasil ditambahkan");
    }

    public void tampilkanReminder() {
        System.out.println("\n📌 REMINDER TUGAS");

        if (TugasStorage.getSemua().isEmpty()) {
            System.out.println("Belum ada tugas 📭");
            return;
        }

        for (Tugas t : TugasStorage.getSemua()) {
            System.out.println("---------------------------");
            System.out.println("📘 " + t.getMataKuliah());
            System.out.println("📝 " + t.getNama());
            System.out.println("📆 Deadline: " + t.getDeadline());
            System.out.println("⚠ Status: " + service.getStatus(t));
        }
    }
}
