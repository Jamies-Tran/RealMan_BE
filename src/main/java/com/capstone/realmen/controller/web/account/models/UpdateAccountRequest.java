package com.capstone.realmen.controller.web.account.models;

import java.time.LocalDate;

import com.capstone.realmen.dto.enums.EGender;

import lombok.Builder;

@Builder
public record UpdateAccountRequest(
        String firstName,
        String lastName,
        String phone,
        String thumbnail,
        LocalDate dob,
        EGender gender) {
}
