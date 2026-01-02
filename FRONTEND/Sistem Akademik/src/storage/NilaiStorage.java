package storage;

import model.MataKuliah;
import java.util.ArrayList;
import java.util.List;

public class NilaiStorage {

    private static List<MataKuliah> semuaNilai = new ArrayList<>();

    public static void tambah(MataKuliah mk) {
        semuaNilai.add(mk);
    }

    public static List<MataKuliah> getSemua() {
        return semuaNilai;
    }
}

