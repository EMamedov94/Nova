package com.example.nova.models.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequestDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
