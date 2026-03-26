package com.example.nova.services.token;

import com.example.nova.models.User;

public interface TokenService {
    String generateAccessToken(User user);
    String generateRefreshToken(User user);
    boolean validateToken(String token);
    String extractUsername(String token);
}
