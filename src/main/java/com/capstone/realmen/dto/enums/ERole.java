package com.capstone.realmen.dto.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum ERole {
    SHOPOWNER,
    STYLIST,
    MASSEUR,
    BRANCHMANAGER,
    RECPETIONIST,
    CUSTOMER;

    public SimpleGrantedAuthority authority() {
        return new SimpleGrantedAuthority(String.format("ROLE_%s", this.name()));
    }
}
