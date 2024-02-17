package com.capstone.realmen.controller.mobile.account.models;

import java.time.LocalDate;

import com.capstone.realmen.dto.enums.EGender;

import lombok.Builder;

@Builder
public record UpdateAccountMobRequest(
        String firstName,
        String lastName,
        String thumbnail,
        LocalDate dob,
        EGender gender) {
}
