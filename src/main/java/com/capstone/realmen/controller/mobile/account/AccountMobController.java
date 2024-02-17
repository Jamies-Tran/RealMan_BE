package com.capstone.realmen.controller.mobile.account;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.mobile.account.models.AccountMobRequestModelMapper;
import com.capstone.realmen.controller.mobile.account.models.AccountMobResponse;
import com.capstone.realmen.controller.mobile.account.models.AccountMobResponseModelMapper;
import com.capstone.realmen.dto.account.Account;
import com.capstone.realmen.service.account.AccountUseCaseService;
import com.capstone.realmen.util.response.ValueResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AccountMobController implements AccountMobAPI {
    @NonNull
    private AccountUseCaseService accountUseCaseService;
    @NonNull
    private AccountMobResponseModelMapper accountMobResponseModelMapper;
    @NonNull
    private AccountMobRequestModelMapper accountMobRequestModelMapper;

    @Override
    public ValueResponse<AccountMobResponse> findById(Long accountId) {
        Account account = accountUseCaseService.findByAccountId(accountId);
        return new ValueResponse<AccountMobResponse>(accountMobResponseModelMapper.toModel(account));
    }
}
