package com.example.nova.services.auth;

import com.example.nova.models.User;
import com.example.nova.models.dto.auth.AuthResponseDto;
import com.example.nova.models.dto.auth.LoginRequestDto;
import com.example.nova.models.dto.auth.RegistrationRequestDto;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {
    User registrationNewUser(RegistrationRequestDto registerDto, HttpServletResponse response);
    AuthResponseDto loginUser(LoginRequestDto loginDto, HttpServletResponse response);
}
