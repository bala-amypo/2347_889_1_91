package com.example.demo.security;

import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class JwtUtil {
    private String secret;
    private long validityInMs;

    public JwtUtil() {
        this.secret = "defaultSecret";
        this.validityInMs = 86400000; // 24 hours
    }

    public JwtUtil(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        return "mock-jwt-token";
    }

    public Map<String, Object> getAllClaims(String token) {
        return Map.of("email", "test@demo.com", "role", "USER");
    }

    public boolean validateToken(String token) {
        return token != null && !token.isEmpty();
    }

    public String getEmail(String token) {
        return "test@demo.com";
    }

    public String getRole(String token) {
        return "USER";
    }
}