package storage;

import model.IPKSemester;
import java.util.ArrayList;
import java.util.List;

public class IPKStorage {

    private static List<IPKSemester> dataIPK = new ArrayList<>();

    public static void tambah(IPKSemester ipk) {
        dataIPK.add(ipk);
    }

    public static List<IPKSemester> getSemua() {
        return dataIPK;
    }
}
