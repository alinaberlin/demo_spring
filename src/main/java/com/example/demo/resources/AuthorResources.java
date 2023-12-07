package com.example.demo.resources;

import com.example.demo.db.AuthorDAO;
import com.example.demo.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController()
@RequestMapping("/authors")
@Validated
public class AuthorResources {
//    AuthorDAO authorDAO = new AuthorDAO();
   private AuthorDAO authorDAO;
   @Autowired
    public AuthorResources(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Author> getAuthors(){
        return authorDAO.getAlAuthors();
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Author getAuthor(@PathVariable("id") int id){
        return authorDAO.getAuthor(id);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Author updateAuthor(@PathVariable("id") int id, Author author) {
        authorDAO.updateAuthor(id, author);
        return author;
    }

    @GetMapping( consumes=MediaType.APPLICATION_JSON_VALUE)
    public void addAuthor( Author author) {
        authorDAO.addAuthor(author);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAuthor(@PathVariable("id") int id) {
        authorDAO.deleteAuthor( id);
    }

}
