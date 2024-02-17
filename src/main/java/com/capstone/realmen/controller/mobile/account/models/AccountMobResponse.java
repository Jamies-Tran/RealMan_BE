package com.capstone.realmen.controller.mobile.account.models;

import java.time.LocalDate;
import com.capstone.realmen.dto.enums.EGender;
import com.capstone.realmen.dto.enums.ERole;
import lombok.Builder;

@Builder
public record AccountMobResponse(
        Long accountId,
        Long branchId,
        String firstName,
        String lastName,
        String staffCode,
        String phone,
        ERole role,
        String thumbnail,
        LocalDate dob,
        EGender gender) {
}
