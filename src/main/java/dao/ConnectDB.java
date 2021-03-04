package dao;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectDB {

    static Connection connection = null;

    public static Connection getCon() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PotteryShopJee", "postgres", "123456");
            System.out.println("Connected");
            return connection;
        } catch (Exception e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return connection;
    }

}

