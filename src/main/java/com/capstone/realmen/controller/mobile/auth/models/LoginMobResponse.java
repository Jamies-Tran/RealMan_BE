package com.capstone.realmen.controller.mobile.auth.models;

import lombok.Builder;
import com.capstone.realmen.dto.enums.ERole;

@Builder
public record LoginMobResponse(
                String accessToken,
                Long accountId,
                Long branchId,
                String staffCode,
                String phone,
                String firstName,
                String lastName,
                Boolean isAccountActive,
                ERole role) {
}
