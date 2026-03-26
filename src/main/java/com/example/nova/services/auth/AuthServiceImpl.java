package com.example.nova.services.auth;

import com.example.nova.enums.Role;
import com.example.nova.models.User;
import com.example.nova.models.dto.auth.AuthResponseDto;
import com.example.nova.models.dto.auth.LoginRequestDto;
import com.example.nova.models.dto.auth.RegistrationRequestDto;
import com.example.nova.repositories.UserRepository;
import com.example.nova.services.token.TokenService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    // Registration new user
    @Override
    public User registrationNewUser(RegistrationRequestDto registerDto, HttpServletResponse response) {

        User newUser = User.builder()
                .username(registerDto.getUsername())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .firstName(registerDto.getFirstName())
                .role(Role.USER)
                .build();

        userRepository.save(newUser);

        return newUser;
    }

    // Login user
    @Override
    public AuthResponseDto loginUser(LoginRequestDto loginDto, HttpServletResponse response) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                )
        );

        User user = (User) authentication.getPrincipal();

        String accessToken = tokenService.generateAccessToken(user);
        String refreshToken = tokenService.generateRefreshToken(user);

        Cookie refreshCookie = new Cookie("refreshToken", refreshToken);
        refreshCookie.setHttpOnly(true);
        refreshCookie.setSecure(true);
        refreshCookie.setPath("/api/auth/refresh");
        refreshCookie.setMaxAge(7 * 24 * 60 * 60); // 7 дней
        refreshCookie.setAttribute("SameSite", "Strict");

        response.addCookie(refreshCookie);

        return new AuthResponseDto(accessToken);
    }
}
