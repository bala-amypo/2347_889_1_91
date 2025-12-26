package com.example.demo.service;

import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;

public interface UserService {

    User register(User user);

    AuthResponse login(User user);

    User findByEmail(String email);

    User getById(Long id);
}
