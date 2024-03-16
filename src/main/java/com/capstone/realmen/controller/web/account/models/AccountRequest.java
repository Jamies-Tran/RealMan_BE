package com.capstone.realmen.controller.web.account.models;

import com.capstone.realmen.dto.enums.EGender;
import com.capstone.realmen.util.constraints.DefaultText;
import com.capstone.realmen.util.constraints.Phone;
import lombok.Builder;
import lombok.NonNull;

import java.time.LocalDate;

@Builder
public record AccountRequest(
        @DefaultText String firstName,
        @DefaultText String lastName,
        @Phone String phone,
        @NonNull Long branchId,
        String staffCode,
        ERoleRequest role,
        String thumbnail,
        LocalDate dob,
        EGender gender) {
}
