package service;

import model.Tugas;
import storage.TugasStorage;

import java.time.LocalDate;

public class TugasService {

    // ================= DASHBOARD =================

    public int hitungDeadlineHariIni() {
        LocalDate today = LocalDate.now();
        int count = 0;

        for (Tugas t : TugasStorage.getSemua()) {
            if (t.getDeadline().isEqual(today)) {
                count++;
            }
        }
        return count;
    }

    public int hitungDeadlineBesok() {
        LocalDate besok = LocalDate.now().plusDays(1);
        int count = 0;

        for (Tugas t : TugasStorage.getSemua()) {
            if (t.getDeadline().isEqual(besok)) {
                count++;
            }
        }
        return count;
    }

    public int hitungTerlambat() {
        LocalDate today = LocalDate.now();
        int count = 0;

        for (Tugas t : TugasStorage.getSemua()) {
            if (t.getDeadline().isBefore(today)) {
                count++;
            }
        }
        return count;
    }

    // ================= CONTROLLER =================

    public String getStatus(Tugas tugas) {
        LocalDate today = LocalDate.now();

        if (tugas.getDeadline().isBefore(today)) {
            return "Terlambat ❌";
        } else if (tugas.getDeadline().isEqual(today)) {
            return "Hari ini ⚠";
        } else {
            return "Aman ✅";
        }
    }
}
