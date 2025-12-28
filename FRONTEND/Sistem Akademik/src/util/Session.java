package util;

public class Session {

    private static int userId;
    private static String username;
    private static String role;

    public static void setUser(int id, String uname, String r) {
        userId = id;
        username = uname;
        role = r;
    }

    public static int getUserId() {
        return userId;
    }

    public static String getUsername() {
        return username;
    }

    public static String getRole() {
        return role;
    }

    public static void clear() {
        userId = 0;
        username = null;
        role = null;
    }
}
