package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        return new ResponseEntity<>(service.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id,
                       @Valid @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
