package com.airlines.yourairlines.enums;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {

    ADMIN("ADMIN"),

    SELLER("EMPLOYEE"),

    BUYER("CLIENT");

    private final String value;

    @Override
    public String getAuthority() {
        return value;
    }
}
