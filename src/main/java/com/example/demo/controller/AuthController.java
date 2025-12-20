package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.exception.BadRequestException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.getEmail());

        if (!user.getPassword().equals(request.getPassword())) { // Use plain check if passwords are not encoded
            throw new BadRequestException("Invalid email or password");
        }

        AuthResponse response = new AuthResponse(
                null, // No token since JWT is removed
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return ResponseEntity.ok(response);
    }
}
