package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Tugas;
import util.DBConnection;

public class TugasRepository {

    public void insert(Tugas tugas) {
        String sql = """
            INSERT INTO tugas (nim, judul, deadline, status, priority)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tugas.getNim());
            ps.setString(2, tugas.getJudul());
            ps.setDate(3, java.sql.Date.valueOf(tugas.getDeadline()));
            ps.setString(4, tugas.getStatus());
            ps.setString(5, tugas.getPriority());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Tugas> findByNim(String nim) {
        List<Tugas> list = new ArrayList<>();

        String sql = "SELECT * FROM tugas WHERE nim = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nim);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tugas t = new Tugas();
                t.setIdTugas(rs.getInt("id_tugas"));
                t.setNim(rs.getString("nim"));
                t.setJudul(rs.getString("judul"));
                t.setDeadline(rs.getDate("deadline").toLocalDate());
                t.setStatus(rs.getString("status"));
                t.setPriority(rs.getString("priority"));
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
