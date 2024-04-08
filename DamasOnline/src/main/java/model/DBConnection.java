package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/DBDamas";
    private static final String USERNAME = "UserAdmin";
    private static final String PASSWORD = "unibyjuniorteam";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return con;
    }
}
