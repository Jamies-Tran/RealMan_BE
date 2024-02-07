package com.capstone.realmen.controller.mobile.account.models;

import java.time.LocalDate;

import com.capstone.realmen.dto.enums.EGender;
import com.capstone.realmen.util.constraints.DefaultText;
import com.capstone.realmen.util.constraints.Phone;
import lombok.Builder;

@Builder
public record AccountMobRequest(
                @DefaultText String firstName,
                @DefaultText String lastName,
                @Phone String phone,
                String thumbnail,
                LocalDate dob,
                EGender gender) {

}
