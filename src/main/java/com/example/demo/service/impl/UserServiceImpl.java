package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {

        if (repository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already in use");
        }

        return repository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {

        User existing = getUserById(id);

        existing.setFullName(user.getFullName());
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());

        return repository.save(existing);
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        repository.delete(user);
    }
}
