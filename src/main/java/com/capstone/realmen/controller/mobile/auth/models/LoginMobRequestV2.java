package com.capstone.realmen.controller.mobile.auth.models;

import jakarta.validation.constraints.NotNull;

public record LoginMobRequestV2(
    @NotNull String staffCode,
    @NotNull String password
) {
}
