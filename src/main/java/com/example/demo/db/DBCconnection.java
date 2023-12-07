package com.example.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCconnection {
    //create connection for mysql

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", System.getenv("USERNAME"), System.getenv("PASSWORD"));
    }
}
