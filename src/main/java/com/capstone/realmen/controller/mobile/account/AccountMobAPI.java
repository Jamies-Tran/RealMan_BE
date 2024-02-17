package com.capstone.realmen.controller.mobile.account;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.realmen.controller.mobile.account.models.AccountMobResponse;
import com.capstone.realmen.util.response.ValueResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "MOB-Accounts", description = "Account management")
@RequestMapping("/mobile/accounts/{accountId}")
public interface AccountMobAPI {
    @GetMapping("/details")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    ValueResponse<AccountMobResponse> findById(@PathVariable Long accountId);
}
