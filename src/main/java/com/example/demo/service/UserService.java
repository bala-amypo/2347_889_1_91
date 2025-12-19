package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User register(User user);

    User getUser(Long id);

    User findByEmail(String email);

    User login(User user) throws Exception; 
