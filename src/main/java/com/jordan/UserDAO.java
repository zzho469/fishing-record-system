package com.jordan;

import java.sql.*;

public class UserDAO {
    private final String url = "jdbc:mysql://localhost:3306/fishing_db?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8";
    private final String user = "root";
    private final String password = "bb3212333";

    public void registerUser(User u) throws SQLException {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, u.getUsername());
            stmt.setString(2, u.getPassword());
            stmt.executeUpdate();
        }
    }

    public boolean userExists(String username) throws SQLException {
        String sql = "SELECT id FROM users WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }
}
