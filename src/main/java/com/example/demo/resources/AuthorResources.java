package com.example.demo.resources;

import com.example.demo.db.AuthorDAO;
import com.example.demo.db.DBLogger;
import com.example.demo.model.Author;
import com.example.demo.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.List;

@RestController()
@RequestMapping("/authors")
@Validated
public class AuthorResources {
//    AuthorDAO authorDAO = new AuthorDAO();
    private DBLogger logger;
   private AuthorDAO authorDAO;
   @Autowired
    public AuthorResources(AuthorDAO authorDAO, DBLogger logger) {
        this.authorDAO = authorDAO;
        this.logger = logger;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Author> getAuthors(){
       Log log = new Log("host", "headers", "", 200,new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), "response");
       logger.log(log);
       return authorDAO.getAlAuthors();
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Author getAuthor(@PathVariable("id") int id){
        return authorDAO.getAuthor(id);
    }

    @PutMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Author updateAuthor(@PathVariable("id") int id, Author author) {
        authorDAO.updateAuthor(id, author);
        return author;
    }

    @PostMapping( consumes=MediaType.APPLICATION_JSON_VALUE)
    public void addAuthor( Author author) {
        authorDAO.addAuthor(author);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAuthor(@PathVariable("id") int id) {
        authorDAO.deleteAuthor( id);
    }

}
