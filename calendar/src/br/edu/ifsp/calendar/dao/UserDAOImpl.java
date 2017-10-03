package br.edu.ifsp.calendar.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.edu.ifsp.calendar.model.User;

public class UserDAOImpl implements UserDAO {
    
    public void insert(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class.forName ("com.mysql.jdbc.Driver");
        
        Connection conn = (Connection) DriverManager
                .getConnection("jdbc:mysql://localhost:3306/calendar", "root", "root");
        
        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";
        PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
        
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        
        statement.execute();
        statement.close();
        conn.close();
    }
    
    public User findByUsername(String username) throws ClassNotFoundException, SQLException {
        User user = null;
        
        Class.forName ("com.mysql.jdbc.Driver");
        
        Connection conn = (Connection) DriverManager
                .getConnection("jdbc:mysql://localhost:3306/calendar", "root", "root");
        
        String sql = "select * from users where username = ?";
        PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
        
        statement.setString(1, username);
        
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
        }
        
        statement.close();
        conn.close();
        rs.close();
        
        return user;  
    }

}
