package com.capstone.realmen.controller.web.account;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.web.account.models.AccountResponse;
import com.capstone.realmen.controller.web.account.models.AccountResponseModelMapper;
import com.capstone.realmen.dto.account.Account;
import com.capstone.realmen.service.account.AccountUseCaseService;
import com.capstone.realmen.util.response.ValueResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AccountController implements AccountAPI {
    @NonNull
    private final AccountUseCaseService accountUseCaseService;
    @NonNull
    private final AccountResponseModelMapper accountResponseModelMapper;

    @Override
    public ValueResponse<AccountResponse> findByAccountId(Long accountId) {
        Account account = accountUseCaseService.findByAccountId(accountId);
        return new ValueResponse<AccountResponse>(accountResponseModelMapper.toModel(account));
    }

}
