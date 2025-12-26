import model.Tugas;
import service.TugasService;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        TugasService tugasService = new TugasService();

        Tugas tugas = new Tugas(
                1,
                "Tugas PBO",
                "Membuat aplikasi Java JDBC",
                LocalDateTime.now().plusDays(3),
                "BELUM"
        );

        tugasService.tambahTugas(tugas);
    }
}
