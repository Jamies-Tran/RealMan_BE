package com.capstone.realmen.controller.mobile.account;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.realmen.controller.mobile.account.models.AccountMobRequest;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Accounts", description = "Account management")
@RequestMapping("/mobile/accounts")
public interface AccountsMobAPI {
    @PostMapping
    void save(@RequestBody @Valid AccountMobRequest accountRequest);
}
