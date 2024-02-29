package com.capstone.realmen.controller.mobile.account;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.realmen.controller.mobile.account.models.AccountMobRequest;
import com.capstone.realmen.controller.mobile.account.models.AccountMobResponse;
import com.capstone.realmen.controller.mobile.account.models.UpdateAccountMobRequest;
import com.capstone.realmen.util.response.PageResponse;
import com.capstone.realmen.util.response.ValueResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@Tag(name = "MOB - Accounts", description = "Account management")
@RequestMapping("/mobile/accounts")
public interface AccountsMobAPI {
    @PostMapping
    void save(@RequestBody @Valid AccountMobRequest accountRequest);

    @GetMapping("/me")
    @PreAuthorize("hasAnyRole({'ROLE_CUSTOMER', 'ROLE_STYLIST', 'ROLE_MASSEUR'})")
    ValueResponse<AccountMobResponse> me();

    @GetMapping("/page-all")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    PageResponse<AccountMobResponse> pageAll(
            @RequestParam(required = false, value = "search", defaultValue = "") String search,
            @RequestParam(required = false, value = "branchId", defaultValue = "") Long branchId,
            @RequestParam(required = false, value = "sorter", defaultValue = "updatedAt_desc") String sorter,
            @RequestParam(required = false, value = "current", defaultValue = "1") @Min(1) Integer current,
            @RequestParam(required = false, value = "pageSize", defaultValue = "20") Integer pageSize);

    @PutMapping("/me")
    @PreAuthorize("hasAnyRole({'ROLE_CUSTOMER', 'ROLE_STYLIST', 'ROLE_MASSEUR'})")
    void updateMe(UpdateAccountMobRequest updateAccountRequest);
}
