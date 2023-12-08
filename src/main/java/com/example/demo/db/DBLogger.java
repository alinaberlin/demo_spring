package com.example.demo.db;

import com.example.demo.model.Log;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class DBLogger {

    public void log(Log log) {
        try (Connection connection = DBCconnection.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("INSERT into log(host, headers, body, status_code, created_at, updated_at, response) VALUES(?,?,?,?,?,?,?)");
            java.util.Date utilDate = new java.sql.Date(log.getCreated_at().getTime());
            java.util.Date utilDate2 = new java.sql.Date(log.getUpdated_at().getTime());
            stm.setString(1, log.getHost());
            stm.setString(2, log.getHeaders());
            stm.setString(3, log.getBody());
            stm.setInt(4, log.getStatus_code());
            stm.setDate(5,  log.getCreated_at());
            stm.setDate(6,  log.getUpdated_at());
            stm.setString(7, log.getResponse());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
