package com.example.nova.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    EMPLOYEE,
    OFFICE_DIRECTOR,
    REGIONAL_DIRECTOR,
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
