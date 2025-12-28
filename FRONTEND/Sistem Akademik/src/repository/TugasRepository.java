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

    public void updateStatusSelesai(int idTugas) {
    String sql = "UPDATE tugas SET status='SELESAI' WHERE id_tugas=?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idTugas);
        ps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public List<Tugas> getAllTugas() {
        return findByQuery("SELECT * FROM tugas");
    }

    public List<Tugas> findByPriority(String priority) {
        return findByQuery("SELECT * FROM tugas WHERE priority = ?", priority);
    }

    public List<Tugas> findDeadlineHariIni() {
        return findByQuery("SELECT * FROM tugas WHERE deadline = CURDATE()");
    }

    public List<Tugas> findDeadlineBesok() {
        return findByQuery("SELECT * FROM tugas WHERE deadline = CURDATE() + INTERVAL 1 DAY");
    }

    public List<Tugas> findTanpaDeadline() {
        return findByQuery("SELECT * FROM tugas WHERE deadline IS NULL");
    }

    public List<Tugas> findByNim(String nim) {
        return findByQuery("SELECT * FROM tugas WHERE nim = ?", nim);
    }

    private List<Tugas> findByQuery(String sql, Object... params) {
        List<Tugas> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tugas t = new Tugas();
                t.setIdTugas(rs.getInt("id_tugas"));
                t.setNim(rs.getString("nim"));
                t.setJudul(rs.getString("judul"));

                if (rs.getDate("deadline") != null) {
                    t.setDeadline(rs.getDate("deadline").toLocalDate());
                }

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
