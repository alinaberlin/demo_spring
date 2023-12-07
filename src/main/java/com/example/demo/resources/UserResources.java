package com.example.demo.resources;

import com.example.demo.db.UserDAO;
import com.example.demo.model.User;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping("/users")
@Validated
public class UserResources {

    private final UserDAO userDAO;

    public UserResources(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User login(Map<String, String> loginData) {
        User user = userDAO.findUser(loginData.get("username"), loginData.get("password"));
        return user;
    }


    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User register(User user) {
        userDAO.addUser(user);
        return user;
    }


    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@PathVariable("id") int id, User user) {
        userDAO.updateUser(id, user);
        return user;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable("id") int id) {
        return userDAO.getUser(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUdser(@PathVariable("id") int id) {
        userDAO.deleteUser(id);
    }
}
