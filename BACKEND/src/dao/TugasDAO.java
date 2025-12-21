package dao;

import util.DBConnection;
import model.Tugas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class TugasDAO {

    public void tambahTugas(Tugas tugas) {

        String sql = """
            INSERT INTO tugas 
            (mata_kuliah_id, judul, deskripsi, deadline, status)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, tugas.getMataKuliahId());
            ps.setString(2, tugas.getJudul());
            ps.setString(3, tugas.getDeskripsi());
            ps.setTimestamp(4, Timestamp.valueOf(tugas.getDeadline()));
            ps.setString(5, tugas.getStatus());

            ps.executeUpdate();
            System.out.println("TUGAS BERHASIL DISIMPAN");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
