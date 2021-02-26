public class UserSession {

    private static UserSession instance;

    private static int userID = 0;

    private UserSession(int userID) {
        this.userID = userID;
    }

    public static int getID() {
        return userID;
    }

    public static void setUserID(int userID) {
        UserSession.userID = userID;
    }

    public static void cleanUserSession() {
        userID = 0;

    }
}