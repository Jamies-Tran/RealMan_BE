package com.capstone.realmen.controller.web.account;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.realmen.controller.web.account.models.AccountRequest;
import com.capstone.realmen.controller.web.account.models.AccountResponse;
import com.capstone.realmen.controller.web.account.models.ChangePasswordRequest;
import com.capstone.realmen.controller.web.account.models.UpdateAccountRequest;
import com.capstone.realmen.dto.enums.EAccountStatus;
import com.capstone.realmen.dto.enums.ERole;
import com.capstone.realmen.util.response.PageResponse;
import com.capstone.realmen.util.response.ValueResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@Tag(name = "WEB-Accounts", description = "Account management")
@RequestMapping("/web/accounts")
public interface AccountsAPI {
    @PostMapping
    @PreAuthorize("hasRole('ROLE_SHOPOWNER')")
    void save(@RequestBody @Valid AccountRequest accountRequest);

    @GetMapping("/me")
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER','ROLE_BRANCHMANAGER','ROLE_RECEPTIONIST'})")
    ValueResponse<AccountResponse> me();

    @GetMapping("/page-all")
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER','ROLE_BRANCHMANAGER','ROLE_RECEPTIONIST'})")
    PageResponse<AccountResponse> pageAll(
            @RequestParam(required = false, value = "search", defaultValue = "") String search,
            @RequestParam(required = false, value = "branchId", defaultValue = "") Long branchId,
            @RequestParam(required = false, value = "accountStatus", defaultValue = "") EAccountStatus status,
            @RequestParam(required = false, value = "role", defaultValue = "") List<ERole> roles,
            @RequestParam(required = false, value = "sorter", defaultValue = "updatedAt_desc") String sorter,
            @RequestParam(required = false, value = "current", defaultValue = "1") @Min(1) Integer current,
            @RequestParam(required = false, value = "pageSize", defaultValue = "20") Integer pageSize);

    @PostMapping("/otp/change-password")
    void createOTPChangePassword(String phone);

    @PatchMapping("/change-password")
    void changePassword(@RequestBody @Valid ChangePasswordRequest changePasswordRequest);

    @PutMapping("/me")
    @PreAuthorize("hasAnyRole({'ROLE_STYLIST', 'ROLE_MASSEUR', 'ROLE_BRANCHMANAGE', 'ROLE_RECEPTIONIST'})")
    void updateMe(@RequestBody UpdateAccountRequest updateAccountRequest);
}
