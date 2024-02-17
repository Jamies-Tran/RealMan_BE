package com.capstone.realmen.info.account;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.capstone.realmen.dto.enums.EAccountStatus;
import com.capstone.realmen.dto.enums.EGender;
import com.capstone.realmen.dto.enums.ERole;

public interface AccountInfo {
    void setAccountId(Long accountId);

    void setBranchId(Long branchId);

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setPhone(String phone);

    void setPassword(String password);

    void setStaffCode(String staffCode);

    void setRole(ERole role);

    void setThumbnail(String thumbnail);

    void setDob(LocalDate dob);

    void setGender(EGender gender);

    void setAccountStatus(EAccountStatus accountStatus);

    void setPassExpiredAt(LocalDateTime passExpiredAt);

    void setIsPassAvailable(Boolean isPassAvailable);

    void setUpdatedAt(LocalDateTime updatedAt);

    Long getAccountId();

    Long getBranchId();

    String getFirstName();

    String getLastName();

    String getPhone();

    String getPassword();

    String getStaffCode();

    ERole getRole();

    String getThumbnail();

    LocalDate getDob();

    EGender getGender();

    EAccountStatus getAccountStatus();

    LocalDateTime getPassExpiredAt();

    Boolean getIsPassAvailable();

    LocalDateTime getUpdatedAt();
}
