package com.capstone.realmen.dto.account;

import java.util.List;
import java.util.Objects;

import com.capstone.realmen.dto.enums.EAccountStatus;
import com.capstone.realmen.dto.enums.ERole;

import lombok.Builder;

@Builder
public record AccountSearchCriteria(
        String search, // first + last name, phone, staffCode
        Long branchId,
        List<ERole> roles,
        EAccountStatus status) {

    public AccountSearchCriteria toLowerCase() {
        return AccountSearchCriteria.builder()
                .search(search.toLowerCase())
                .branchId(branchId)
                .roles(roles)
                .status(status)
                .build();
    }

    public Boolean hasSearchEmpty() {
        return Objects.isNull(search) || search.isEmpty();
    }

    public Boolean hasBranchIdEmpty() {
        return Objects.isNull(branchId);
    }

    public Boolean hasStatusEmpty() {
        return Objects.isNull(status);
    }
}
