package com.capstone.realmen.controller.web.account;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.capstone.realmen.controller.web.account.models.AccountResponse;
import com.capstone.realmen.util.response.ValueResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "WEB-Accounts", description = "Account management")
@RequestMapping("/web/accounts/{accountId}")
public interface AccountAPI {
    @GetMapping("/details")
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER','ROLE_BRANCHMANAGER','ROLE_RECEPTIONIST'})")
    ValueResponse<AccountResponse> findByAccountId(@PathVariable Long accountId);

    @DeleteMapping
    @PreAuthorize("hasRole('ROLE_SHOPOWNER')")
    void deleteAccount(@PathVariable Long accountId);
}
