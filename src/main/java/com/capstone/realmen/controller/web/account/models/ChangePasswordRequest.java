package com.capstone.realmen.controller.web.account.models;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ChangePasswordRequest(
                @NotNull String phone,
                @NotNull String otp,
                @NotNull String newPassword) {
}
