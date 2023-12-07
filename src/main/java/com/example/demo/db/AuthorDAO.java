package com.example.demo.db;

import com.example.demo.model.Author;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class AuthorDAO  extends SupremeDAO{
    public List<Author> getAlAuthors() {
        List<Author> authorlist = new ArrayList<>();
        try (Connection connection = DBCconnection.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");
            while (rs.next()) {
                Author author = new Author(rs.getInt("id"),rs.getString("name"));
                authorlist.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorlist;
    }
    public Author getAuthor(int id) {
        try (Connection connection = DBCconnection.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM authors WHERE id = ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new Author(
                        rs.getInt("id"),
                        rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void addAuthor(Author author) {
        try (Connection connection =DBCconnection.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO authors(name ) VALUES(?) ");
            stm.setString(1, author.getName());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateAuthor(int id, Author author) {
        try (Connection connection = DBCconnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE authors SET name = ? WHERE id = ?");
            ps.setString(1, author.getName());
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAuthor(int id) {
        try (Connection connection = DBCconnection.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM authors WHERE id = ?");
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
