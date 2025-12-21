package repository;

import model.User;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository {

    // Login menggunakan username dan password
    public User login(String username, String password) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT * FROM user WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
    
            // Tambahkan log di sini
            System.out.println("Username yang dikirim ke query: '" + username + "'");
            System.out.println("Password yang dikirim ke query: '" + password + "'");
    
            ps.setString(1, username);
            ps.setString(2, password);
    
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getInt("streak"),
                        rs.getDouble("ipk"),
                        rs.getInt("today"),
                        rs.getInt("level")
                );
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }    
}
