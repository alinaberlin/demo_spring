package com.example.demo;

import com.example.demo.db.AuthorDAO;
import com.example.demo.db.BookDAO;
import com.example.demo.db.UserDAO;
import com.example.demo.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public AuthorDAO authorDAO(){
        return new AuthorDAO();
    }
    @Bean
    public BookDAO bookDAODAO(){
        return new BookDAO();
    }
    @Bean
    public UserDAO userDAO(){
        return new UserDAO();
    }
}
