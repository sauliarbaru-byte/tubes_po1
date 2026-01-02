package controller;

import model.MataKuliah;
import service.NilaiService;
import storage.NilaiStorage;

import java.util.Scanner;

public class NilaiController {

    private NilaiService service = new NilaiService();

    public void inputNilai() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nama Mata Kuliah: ");
        String nama = sc.nextLine();

        System.out.print("SKS: ");
        int sks = sc.nextInt();
        sc.nextLine();

        System.out.print("Nilai (A/AB/B/BC/C/D/E): ");
        String nilai = sc.nextLine();

        NilaiStorage.tambah(new MataKuliah(nama, sks, nilai));
        System.out.println("✅ Nilai berhasil ditambahkan");
    }

    public void tampilkanIPK() {
        System.out.printf("📘 IPS: %.2f\n", service.hitungIPS());
        System.out.printf("🎓 IPK: %.2f\n", service.hitungIPK());
    }
}
