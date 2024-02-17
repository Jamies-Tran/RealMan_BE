package com.capstone.realmen.dto.account;

import com.capstone.realmen.dto.enums.EAccountStatus;
import com.capstone.realmen.dto.enums.EGender;
import com.capstone.realmen.dto.enums.ERole;

import lombok.Builder;
import java.time.LocalDate;
import java.util.Objects;

@Builder
public record Account(
                Long accountId,
                Long branchId,
                String firstName,
                String lastName,
                String phone,
                String password,
                String staffCode,
                ERole role,
                String thumbnail,
                LocalDate dob,
                EGender gender,
                EAccountStatus accountStatus) {
        public EAccountStatus accountStatus() {
                return Objects.nonNull(accountStatus) ? accountStatus : EAccountStatus.ACTIVATED;
        }

        public Long branchId() {
                return Objects.nonNull(branchId) ? branchId : null;
        }
}
