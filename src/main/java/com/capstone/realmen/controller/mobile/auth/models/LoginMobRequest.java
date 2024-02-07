package com.capstone.realmen.controller.mobile.auth.models;

import com.capstone.realmen.util.constraints.Phone;

import jakarta.validation.constraints.NotNull;

public record LoginMobRequest(
        @Phone String phone,
        @NotNull String otp) {
}
