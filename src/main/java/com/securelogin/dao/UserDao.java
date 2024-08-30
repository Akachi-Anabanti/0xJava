package com.securelogin.dao;

import com.securelogin.model.User;
import com.securelogin.util.DatabaseUtil;

import java.sql.*;

public class UserDao {
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?;";
        
        try (Connection conn = DatabaseUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
            ) {
                    pstmt.setString(1, sql);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        User user = new User();
                        user.setId(rs.getLong("id"));
                        user.setUsername(rs.getString("username"));
                        user.setPsswordHash(rs.getString("password"));
                        user.setFingerprint(rs.getBytes("fingerprint"));
                        user.setLastLatitude(rs.getDouble("last_latitude"));
                        user.setLastLongitude(rs.getDouble("last_longitude"));

                        return user;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
}