package com.capstone.realmen.controller.web.auth.models;

import com.capstone.realmen.dto.enums.ERole;

import lombok.Builder;

@Builder
public record LoginResponse(
        String accessToken,
        Long accountId,
        Long branchId,
        String staffCode,
        String firstName,
        String lastName,
        ERole role) {
}
