package repository;

import model.Tugas;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TugasRepository {

    public void tambahTugas(Tugas tugas) {
        String sql = "INSERT INTO tugas (mata_kuliah_id, judul, deskripsi, deadline, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, tugas.getMataKuliahId());
            ps.setString(2, tugas.getJudul());
            ps.setString(3, tugas.getDeskripsi());
            ps.setTimestamp(4, java.sql.Timestamp.valueOf(tugas.getDeadline()));
            ps.setString(5, tugas.getStatus());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
