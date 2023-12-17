package backend.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/movies";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORDD = "password";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORDD);
    }
}