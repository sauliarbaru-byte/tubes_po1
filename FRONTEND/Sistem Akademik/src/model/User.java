package model;

import java.time.LocalDate;

public class User {

    private int id;
    private String username;
    private String password;
    private String role;
    private double ipk;
    private int streak;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public double getIpk() { return ipk; }
    public void setIpk(double ipk) { this.ipk = ipk; }

    public int getStreak() { return streak; }
    public void setStreak(int streak) { this.streak = streak; }

    
    public String getToday() {
        return LocalDate.now().getDayOfWeek().toString();
    }

    public int getLevel() {
        return streak / 5;
    }
}
