package com.example.demo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Validated
public class LoginControler {

    @PostMapping("/login")
    public AuthRequest getToken(@Validated @RequestBody AuthRequest request) {
        return request;
    }

}
