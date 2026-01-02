package model;

public class User {
    private String username;
    private String password;
    private int semester;
    private double ipk;
    private int totalSks;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.semester = 4;
        this.ipk = 3.75;
        this.totalSks = 72;
    }

    public String getUsername() {
        return username;
    }

    // 🔥 INI YANG KURANG
    public String getPassword() {
        return password;
    }

    public double getIpk() {
        return ipk;
    }

    public int getTotalSks() {
        return totalSks;
    }
}
