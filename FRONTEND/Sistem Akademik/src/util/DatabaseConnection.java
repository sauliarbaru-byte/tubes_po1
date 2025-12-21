package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Sesuaikan dengan nama database kamu
    private static final String URL =
            "jdbc:mysql://localhost:3306/Sistem_Akademik?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root"; // username MySQL
    private static final String PASSWORD = ""; // password MySQL

    public static Connection getConnection() {
        try {
            // Pastikan driver MySQL sudah di classpath
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Debug: cek koneksi berhasil
            if (conn != null) {
                System.out.println("Koneksi database berhasil!");
            }

            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL tidak ditemukan!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Gagal koneksi ke database!");
            e.printStackTrace();
        }

        return null;
    }
}
