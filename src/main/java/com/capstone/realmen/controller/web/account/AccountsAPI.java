package com.capstone.realmen.controller.web.account;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.realmen.controller.web.account.models.AccountRequest;
import com.capstone.realmen.controller.web.account.models.AccountResponse;
import com.capstone.realmen.dto.enums.EAccountStatus;
import com.capstone.realmen.util.response.PageResponse;
import com.capstone.realmen.util.response.ValueResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@Tag(name = "Accounts", description = "Account management")
@RequestMapping("/web/accounts")
public interface AccountsAPI {
    @PostMapping
    @PreAuthorize("hasRole('ROLE_SHOPOWNER')")
    void save(@RequestBody @Valid AccountRequest accountRequest);

    @GetMapping("/me")
    ValueResponse<AccountResponse> me();

    @GetMapping("/page-all")
    PageResponse<AccountResponse> pageAll(
            @RequestParam(required = false, value = "search", defaultValue = "") String search,
            @RequestParam(required = false, value = "branchId", defaultValue = "") Long branchId,
            @RequestParam(required = false, value = "accountStatus", defaultValue = "") EAccountStatus status,
            @RequestParam(required = false, value = "sorter", defaultValue = "updatedAt") String sorter,
            @RequestParam(required = false, value = "current", defaultValue = "1") @Min(1) Integer current,
            @RequestParam(required = false, value = "pageSize", defaultValue = "20") Integer pageSize);
}
