package com.capstone.realmen.controller.mobile.auth.models;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record LoginMobResponse(
        String accessToken,
        Long accountId,
        String phone,
        String firstName,
        String lastName,
        LocalDateTime passExpiredAt,
        Boolean isAccountActive) {
}
