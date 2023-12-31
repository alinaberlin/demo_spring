package com.example.demo.resources;

import com.example.demo.db.BookDAO;
import com.example.demo.db.DBLogger;
import com.example.demo.model.Book;
import com.example.demo.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.List;

@RestController()
@RequestMapping("/books")
@Validated
public class BookResource {
//    BookDAO bookDAO = new BookDAO();

      private BookDAO bookDAO;
      private DBLogger logger;

    @Autowired
    public BookResource(BookDAO bookDAO,  DBLogger logger) {

        this.bookDAO = bookDAO;
        this.logger = logger;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBooks() {
        return bookDAO.getAlBook();
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBook(@PathVariable("id") int id) {
        Log log = new Log("host", "headers", "", 200,new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), "response");
        logger.log(log);
        Book book = bookDAO.getBook(id);
        if (book == null) {
            throw new RuntimeException();
        }
        return book;

    }
    @PutMapping(path = "/{id}")
    public Book updateBook(@PathVariable("id") int id, Book book) {
        if (bookDAO.updateBook(id, book) == 0) {
            throw new RuntimeException();
        }
        return book;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBook(@PathVariable("id") int id) {
        bookDAO.deleteBook(id);
    }
}
