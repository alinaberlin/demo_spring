package com.example.demo.db;

import com.example.demo.model.Author;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class UserDAO {
    public void addUser(User user) {
        try (Connection connection = DBCconnection.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO users(username, password, role ) VALUES(?, ?, ?) ");
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getRole().toString());
            stm.setString(3, user.getPassword());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public User findUser(String username, String password) {
        try (Connection connection = DBCconnection.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("Select * from users where username = ? and password =?");
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("password"), Role.valueOf(rs.getString("role")));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUser(int id) {
        try (Connection connection = DBCconnection.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("Select * from users where id=?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("password"), Role.valueOf(rs.getString("role")));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser(int id, User user) {
        try (Connection connection = DBCconnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE user SET username = ?, password = ?, role = ? WHERE id = ?");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole().toString());
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteUser(int id) {
        try (Connection connection = DBCconnection.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


