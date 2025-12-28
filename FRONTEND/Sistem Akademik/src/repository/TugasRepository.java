package repository;

import model.Tugas;
import util.DBConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TugasRepository {

    public void tambahTugas(Tugas tugas) {
        String sql = "INSERT INTO tugas (mata_kuliah_id, judul, deskripsi, deadline, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, tugas.getMataKuliahId());
            ps.setString(2, tugas.getJudul());
            ps.setString(3, tugas.getDeskripsi());
            ps.setTimestamp(4, Timestamp.valueOf(tugas.getDeadline()));
            ps.setString(5, tugas.getStatus());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public List<Tugas> getAllTugas() {
        List<Tugas> list = new ArrayList<>();
        String sql = "SELECT * FROM tugas ORDER BY deadline ASC";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Tugas t = new Tugas();
                t.setMataKuliahId(rs.getInt("mata_kuliah_id"));
                t.setJudul(rs.getString("judul"));
                t.setDeskripsi(rs.getString("deskripsi"));
                t.setDeadline(rs.getTimestamp("deadline").toLocalDateTime());
                t.setStatus(rs.getString("status"));

                list.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // =======================
// FILTER PRIORITY
// =======================
public List<Tugas> findByPriority(String status) {
    List<Tugas> list = new ArrayList<>();
    String sql = "SELECT * FROM tugas WHERE status = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, status);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Tugas t = new Tugas();
            t.setMataKuliahId(rs.getInt("mata_kuliah_id"));
            t.setJudul(rs.getString("judul"));
            t.setDeskripsi(rs.getString("deskripsi"));
            t.setDeadline(rs.getTimestamp("deadline").toLocalDateTime());
            t.setStatus(rs.getString("status"));
            list.add(t);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}

// =======================
// DEADLINE HARI INI
// =======================
public List<Tugas> findDeadlineHariIni() {
    List<Tugas> list = new ArrayList<>();
    String sql = "SELECT * FROM tugas WHERE DATE(deadline) = CURDATE()";

    try (Connection conn = DBConnection.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {
            Tugas t = new Tugas();
            t.setMataKuliahId(rs.getInt("mata_kuliah_id"));
            t.setJudul(rs.getString("judul"));
            t.setDeskripsi(rs.getString("deskripsi"));
            t.setDeadline(rs.getTimestamp("deadline").toLocalDateTime());
            t.setStatus(rs.getString("status"));
            list.add(t);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}

// =======================
// DEADLINE BESOK
// =======================
public List<Tugas> findDeadlineBesok() {
    List<Tugas> list = new ArrayList<>();
    String sql = "SELECT * FROM tugas WHERE DATE(deadline) = CURDATE() + INTERVAL 1 DAY";

    try (Connection conn = DBConnection.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {
            Tugas t = new Tugas();
            t.setMataKuliahId(rs.getInt("mata_kuliah_id"));
            t.setJudul(rs.getString("judul"));
            t.setDeskripsi(rs.getString("deskripsi"));
            t.setDeadline(rs.getTimestamp("deadline").toLocalDateTime());
            t.setStatus(rs.getString("status"));
            list.add(t);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}

// =======================
// TANPA DEADLINE
// =======================
public List<Tugas> findTanpaDeadline() {
    List<Tugas> list = new ArrayList<>();
    String sql = "SELECT * FROM tugas WHERE deadline IS NULL";

    try (Connection conn = DBConnection.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {
            Tugas t = new Tugas();
            t.setMataKuliahId(rs.getInt("mata_kuliah_id"));
            t.setJudul(rs.getString("judul"));
            t.setDeskripsi(rs.getString("deskripsi"));
            t.setStatus(rs.getString("status"));
            list.add(t);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}

// =======================
// UPDATE STATUS SELESAI
// =======================
public void updateStatusSelesai(int id) {
    String sql = "UPDATE tugas SET status = 'SELESAI' WHERE id = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, id);
        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
