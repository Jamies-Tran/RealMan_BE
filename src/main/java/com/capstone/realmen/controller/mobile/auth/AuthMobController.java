package com.capstone.realmen.controller.mobile.auth;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.mobile.auth.models.LoginMobRequest;
import com.capstone.realmen.controller.mobile.auth.models.LoginMobRequestV2;
import com.capstone.realmen.controller.mobile.auth.models.LoginMobResponse;
import com.capstone.realmen.service.account.AccountUseCaseService;
import com.capstone.realmen.service.auth.AuthUseCaseService;
import com.capstone.realmen.util.response.ValueResponse;

import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthMobController implements AuthMobAPI {
    @NonNull
    private final AccountUseCaseService accountUseCaseService;
    @NonNull
    private final AuthUseCaseService authUseCaseService;

    @Override
    public void createOTP(String phone) {
        accountUseCaseService.createOTP(phone);
    }

    @Override
    public ValueResponse<LoginMobResponse> customerLogin(@Valid LoginMobRequest loginMobRequest) {
        LoginMobResponse response = authUseCaseService.loginMobile(loginMobRequest);
        return new ValueResponse<LoginMobResponse>(response);
    }

    @Override
    public ValueResponse<LoginMobResponse> staffLogin(@Valid LoginMobRequestV2 loginMobRequest) {
        LoginMobResponse response = authUseCaseService.loginMobileV2(loginMobRequest);
        return new ValueResponse<>(response);
    }
}
