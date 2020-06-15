package com.example.sole_shifter.model.type;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, EDITOR, AUTHOR, ORD_USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
