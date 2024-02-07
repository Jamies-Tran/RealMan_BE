package com.capstone.realmen.controller.mobile.account;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.mobile.account.models.AccountMobRequestModelMapper;
import com.capstone.realmen.controller.mobile.account.models.AccountMobRequest;
import com.capstone.realmen.dto.account.Account;
import com.capstone.realmen.service.account.AccountUseCaseService;

import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AccountsMobController implements AccountsMobAPI {
    @NonNull
    private final AccountUseCaseService accountUseCaseService;
    @NonNull
    private final AccountMobRequestModelMapper accountMobRequestModelMapper;

    @Override
    public void save(@Valid AccountMobRequest accountRequest) {
        Account account = accountMobRequestModelMapper.toDto(accountRequest);
        accountUseCaseService.save(account);
    }

}
