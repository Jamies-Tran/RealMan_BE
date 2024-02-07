package com.capstone.realmen.controller.web.auth.models;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record LoginRequest(
        @NotNull String staffCode,
        @NotNull String password) {
}
