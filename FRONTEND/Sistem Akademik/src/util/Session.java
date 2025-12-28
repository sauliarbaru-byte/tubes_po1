package util;

public class Session {

    private static int userId;
    private static String username;

    public static void setUser(int id, String username) {
        Session.userId = id;
        Session.username = username;
    }

    public static int getUserId() {
        return userId;
    }

    public static String getUsername() {
        return username;
    }

    public static boolean isLogin() {
        return username != null;
    }

    public static void clear() {
        userId = 0;
        username = null;
    }
}
