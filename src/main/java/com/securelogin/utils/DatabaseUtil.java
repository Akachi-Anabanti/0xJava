package com.securelogin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseUtil {
    private static final String URL = "jbc:sqlite:securelogin.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("SQLite JDBC driver not found");
        }
    }

    public static Connection geConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}