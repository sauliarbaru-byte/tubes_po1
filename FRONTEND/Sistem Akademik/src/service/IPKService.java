package service;

import model.IPKSemester;
import storage.IPKStorage;

public class IPKService {

    public double hitungIPKKeseluruhan() {
        if (IPKStorage.getSemua().isEmpty()) return 0;

        double total = 0;
        for (IPKSemester i : IPKStorage.getSemua()) {
            total += i.getIpk();
        }
        return total / IPKStorage.getSemua().size();
    }
}
