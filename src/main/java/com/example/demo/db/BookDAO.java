package com.example.demo.db;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class BookDAO extends SupremeDAO{
    public List<Book> getAlBook() {
        List<Book> bookList = new ArrayList<>();
        try (Connection connection = DBCconnection.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT b.id as bookId, b.title as title, b.price as price, b.quantity as quantity, " +
                    "a.id as authorId, a.name as name" +
                    " FROM books b INNER JOIN authors a on a.id=b.author_id");
            while (rs.next()) {
                Author author = new Author(rs.getInt("authorId"), rs.getString("name"));
                Book book = new Book(rs.getInt("bookId"), rs.getString("title"),author, rs.getDouble("price"), rs.getInt("quantity"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public Book getBook(int id) {
        try (Connection connection = DBCconnection.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("SELECT b.id as bookId, b.title as title, b.price as price, b.quantity as quantity, " +
                    "a.id as authorId, a.name as name" +
                            " FROM books b INNER JOIN authors a on a.id=b.author_id WHERE b.id = ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Author author = new Author(rs.getInt("authorId"), rs.getString("name"));
                return new Book(
                        rs.getInt("bookId"),
                        rs.getString("title"),
                        author,
                        rs.getDouble("price"),
                        rs.getInt("quantity"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void addBook(Book book) {
        try (Connection connection =DBCconnection.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO books(title, author_id, price, quantity ) VALUES(?, ?, ?, ?) ");
            stm.setString(1, book.getTitle());
            stm.setInt(2, book.getAuthor().getId());
            stm.setDouble(3, book.getPrice());
            stm.setInt(4, book.getQuantity());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int updateBook(int id, Book book) {
        try (Connection connection = DBCconnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE books SET title = ?, author_Id = ?, price = ? WHERE id = ?");
            ps.setString(2, book.getTitle());
            ps.setInt(3, book.getAuthor().getId());
            ps.setDouble(4, book.getPrice());
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void deleteBook(int id) {
        try (Connection connection = DBCconnection.getConnection()) {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM books WHERE id = ?");
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

