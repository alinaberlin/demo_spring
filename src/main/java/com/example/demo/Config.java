package com.example.demo;

import com.example.demo.db.AuthorDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public AuthorDAO authorDAO(){
        return new AuthorDAO();
    }
}
