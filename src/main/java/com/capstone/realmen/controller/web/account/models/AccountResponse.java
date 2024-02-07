package com.capstone.realmen.controller.web.account.models;

import java.time.LocalDate;
import com.capstone.realmen.dto.enums.EAccountStatus;
import com.capstone.realmen.dto.enums.EGender;
import com.capstone.realmen.dto.enums.ERole;

import lombok.Builder;

@Builder
public record AccountResponse(
        Long accountId,
        Long branchId,
        String firstName,
        String lastName,
        String phone,
        String staffCode,
        ERole role,
        String thumbnail,
        LocalDate dob,
        EGender gender,
        EAccountStatus accountStatus) {
}
