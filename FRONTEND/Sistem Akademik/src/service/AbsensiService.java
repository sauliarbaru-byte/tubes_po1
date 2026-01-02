package service;

import model.Absensi;
import storage.AbsensiStorage;

public class AbsensiService {

    public int totalHadir() {
        int count = 0;
        for (Absensi a : AbsensiStorage.getSemua()) {
            if (a.isHadir()) count++;
        }
        return count;
    }

    public int totalTidakHadir() {
        int count = 0;
        for (Absensi a : AbsensiStorage.getSemua()) {
            if (!a.isHadir()) count++;
        }
        return count;
    }

    public double persentaseKehadiran() {
        int total = AbsensiStorage.getSemua().size();
        if (total == 0) return 0;
        return (totalHadir() * 100.0) / total;
    }

    public int hitungStreak() {
        int streak = 0;
        for (int i = AbsensiStorage.getSemua().size() - 1; i >= 0; i--) {
            if (AbsensiStorage.getSemua().get(i).isHadir()) {
                streak++;
            } else {
                break;
            }
        }
        return streak;
    }
}
