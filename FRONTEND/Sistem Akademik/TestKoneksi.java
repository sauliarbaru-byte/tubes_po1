import util.DBConnection;
import java.sql.Connection;

public class TestKoneksi {
    public static void main(String[] args) {
        Connection c = DBConnection.getConnection();
        if (c != null) {
            System.out.println("KONEKSI BERHASIL");
        } else {
            System.out.println("KONEKSI GAGAL");
        }
    }
}
