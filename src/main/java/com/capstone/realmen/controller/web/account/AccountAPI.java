package com.capstone.realmen.controller.web.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.realmen.controller.web.account.models.AccountResponse;
import com.capstone.realmen.util.response.ValueResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Accounts", description = "Account management")
@RequestMapping("/web/accounts/{accountId}")
public interface AccountAPI {
    @GetMapping("/details")
    ValueResponse<AccountResponse> findByAccountId(@PathVariable Long accountId);
}
