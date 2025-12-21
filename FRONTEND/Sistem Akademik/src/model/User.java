package model;

public class User {
    private int id;
    private String username;
    private int streak;
    private double ipk;
    private int today;
    private int level;

    // Constructor lengkap
    public User(int id, String username, int streak, double ipk, int today, int level) {
        this.id = id;
        this.username = username;
        this.streak = streak;
        this.ipk = ipk;
        this.today = today;
        this.level = level;
    }

    // Constructor dummy untuk testing
    public User(String username, int streak, double ipk, int today, int level) {
        this.id = 0; // default
        this.username = username;
        this.streak = streak;
        this.ipk = ipk;
        this.today = today;
        this.level = level;
    }

    // Getter
    public int getId() { return id; }
    public String getUsername() { return username; }
    public int getStreak() { return streak; }
    public double getIpk() { return ipk; }
    public int getToday() { return today; }
    public int getLevel() { return level; }
}
