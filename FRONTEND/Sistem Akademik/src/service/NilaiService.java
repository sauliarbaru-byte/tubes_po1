package service;

import model.MataKuliah;
import storage.NilaiStorage;

import java.util.List;

public class NilaiService {

    public double konversiBobot(String nilai) {
        return switch (nilai.toUpperCase()) {
            case "A" -> 4.0;
            case "AB" -> 3.5;
            case "B" -> 3.0;
            case "BC" -> 2.5;
            case "C" -> 2.0;
            case "D" -> 1.0;
            case "E" -> 0.0;
            default -> 0.0;
        };
    }

    public double hitungIPS() {
        List<MataKuliah> data = NilaiStorage.getSemua();
        double totalBobot = 0;
        int totalSKS = 0;

        for (MataKuliah mk : data) {
            totalBobot += konversiBobot(mk.getNilaiHuruf()) * mk.getSks();
            totalSKS += mk.getSks();
        }

        return totalSKS == 0 ? 0 : totalBobot / totalSKS;
    }

    public double hitungIPK() {
        // Untuk sekarang IPK = IPS (karena belum dipisah semester)
        return hitungIPS();
    }
}
