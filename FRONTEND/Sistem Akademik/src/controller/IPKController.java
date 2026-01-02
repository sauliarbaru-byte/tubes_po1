package controller;

import model.IPKSemester;
import service.IPKService;
import storage.IPKStorage;

import java.util.Scanner;

public class IPKController {

    private IPKService service = new IPKService();

    public void tambahIPK() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Semester ke-: ");
        int semester = sc.nextInt();

        System.out.print("IPK: ");
        double ipk = sc.nextDouble();

        IPKStorage.tambah(new IPKSemester(semester, ipk));
        System.out.println("✅ IPK semester berhasil ditambahkan");
    }

    public void tampilkanGrafikTeks() {
        System.out.println("\n📈 GRAFIK IPK PER SEMESTER");

        if (IPKStorage.getSemua().isEmpty()) {
            System.out.println("Belum ada data IPK");
            return;
        }

        for (IPKSemester i : IPKStorage.getSemua()) {
            System.out.print("Semester " + i.getSemester() + " : ");
            int bar = (int) (i.getIpk() * 10);
            for (int j = 0; j < bar; j++) {
                System.out.print("█");
            }
            System.out.println(" (" + i.getIpk() + ")");
        }

        System.out.printf("\n🎓 IPK KESELURUHAN: %.2f\n",
                service.hitungIPKKeseluruhan());
    }
}
