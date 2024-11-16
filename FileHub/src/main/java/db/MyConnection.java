package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private static Connection connection = null;
    
    public static Connection getConnection() {
        try {
            // Try loading the driver explicitly with error message
            try {
                Class.forName("org.mariadb.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.err.println("MariaDB JDBC Driver not found. Including error details:");
                e.printStackTrace();
                throw new RuntimeException("Failed to load MariaDB JDBC driver", e);
            }
            
            // Try creating the connection with error message
            try {
                connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/filehub?useSSL=false",
                    "root",
                    "chaikidukan120"
                );
            } catch (SQLException e) {
                System.err.println("Failed to create database connection. Including error details:");
                e.printStackTrace();
                throw new RuntimeException("Failed to create database connection", e);
            }
            
            return connection;
        } catch (RuntimeException e) {
            System.err.println("Critical error in database connection:");
            e.printStackTrace();
            throw e;
        }
    }
    
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.err.println("Error closing connection:");
                ex.printStackTrace();
            }
        }
    }
}