package dao;

import db.MyConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static boolean isEmailExists(String email)throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
        pStatement.setString(1, email); 
        ResultSet result = pStatement.executeQuery();
        
        return result.next();
    }

    public static boolean isUsernameExists(String username) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM users WHERE name = ?");
        pStatement.setString(1, username); 
        ResultSet result = pStatement.executeQuery();
        
        return result.next();
    }

    public static int saveUser(User user) throws SQLException{
        Connection connection = MyConnection.getConnection();
        PreparedStatement pStatement = connection.prepareStatement("insert into users values (default, ?, ?, ?)");
        pStatement.setString(1, user.getName());
        pStatement.setString(2, user.getEmail());
        pStatement.setString(3, user.getPassword());
        return pStatement.executeUpdate();
    }

    public static boolean isUser(String name, String email, String password) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement pStatement;
        
        // Check if email or name is provided
        if (name == null || name.isEmpty()) {
            pStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            pStatement.setString(1, email);
        } else {
            pStatement = connection.prepareStatement("SELECT * FROM users WHERE name = ? AND password = ?");
            pStatement.setString(1, name);
        }
        
        pStatement.setString(2, password);
        ResultSet result = pStatement.executeQuery();
        
        return result.next();
    }
    

}
