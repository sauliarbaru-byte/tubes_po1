package util;

public class Session {

    private static String nim;
    private static String username;

    public static void setUser(String nim, String username) {
        Session.nim = nim;
        Session.username = username;
    }

    public static String getNim() {
        return nim;
    }

    public static String getUsername() {
        return username;
    }

    public static boolean isLogin() {
        return nim != null;
    }

    public static void clear() {
        nim = null;
        username = null;
    }
}
