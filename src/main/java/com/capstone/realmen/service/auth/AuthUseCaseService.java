package com.capstone.realmen.service.auth;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.capstone.realmen.controller.error.exceptions.AccountLoginException;
import com.capstone.realmen.controller.mobile.auth.models.LoginMobRequest;
import com.capstone.realmen.controller.mobile.auth.models.LoginMobResponse;
import com.capstone.realmen.controller.web.auth.models.LoginRequest;
import com.capstone.realmen.controller.web.auth.models.LoginResponse;
import com.capstone.realmen.dto.account.Account;
import com.capstone.realmen.dto.enums.EAccountStatus;
import com.capstone.realmen.security.encoder.AppPasswordEncoder;
import com.capstone.realmen.security.jwt.JwtService;
import com.capstone.realmen.service.account.AccountUseCaseService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthUseCaseService {
    @NonNull
    private final AccountUseCaseService accountUseCaseService;
    @NonNull
    private final JwtService jwtService;
    @NonNull
    private final AppPasswordEncoder appPasswordEncoder;
    @Value("${app.default.password}")
    private String appDefaultPassword;
    @Value("${app.mobile.default.password}")
    private String appMobDefaultPassword;

    public LoginResponse loginWeb(LoginRequest loginRequest) {
        Account foundAccount = accountUseCaseService.findByStaffCode(loginRequest.staffCode());
        if (!appPasswordEncoder.passwordEncoder().matches(loginRequest.password(), foundAccount.password())) {
            throw new AccountLoginException();
        }
        return LoginResponse.builder()
                .accountId(foundAccount.accountId())
                .branchId(foundAccount.branchId())
                .staffCode(foundAccount.staffCode())
                .firstName(foundAccount.firstName())
                .lastName(foundAccount.lastName())
                .accessToken(jwtService.generateJwtToken(foundAccount.staffCode()))
                .role(foundAccount.role())
                .build();
    }

    public LoginMobResponse loginMobile(LoginMobRequest loginMobRequest) {
        Account foundAccount = accountUseCaseService.findByPhone(loginMobRequest.phone());
        if (loginMobRequest.otp().equals(appMobDefaultPassword)) {
            return LoginMobResponse.builder()
                    .accessToken(jwtService.generateJwtToken(loginMobRequest.phone()))
                    .accountId(foundAccount.accountId())
                    .phone(foundAccount.phone())
                    .firstName(foundAccount.firstName())
                    .lastName(foundAccount.lastName())
                    .passExpiredAt(foundAccount.passExpiredAt())
                    .isAccountActive(foundAccount.accountStatus().equals(EAccountStatus.ACTIVATED))
                    .build();
        }
        Boolean isPassInValidTime = Objects.nonNull(foundAccount.passExpiredAt())
                && (foundAccount.passExpiredAt().isEqual(LocalDateTime.now())
                        || LocalDateTime.now().isBefore(foundAccount.passExpiredAt()));
        if (!appPasswordEncoder.passwordEncoder().matches(loginMobRequest.otp(), foundAccount.password())
                || !isPassInValidTime || !foundAccount.isPassAvailable()) {
            throw new AccountLoginException();
        }
        accountUseCaseService.disablePassword(foundAccount.accountId());
        return LoginMobResponse.builder()
                .accessToken(jwtService.generateJwtToken(loginMobRequest.phone()))
                .accountId(foundAccount.accountId())
                .phone(foundAccount.phone())
                .firstName(foundAccount.firstName())
                .lastName(foundAccount.lastName())
                .passExpiredAt(foundAccount.passExpiredAt())
                .isAccountActive(foundAccount.accountStatus().equals(EAccountStatus.ACTIVATED))
                .build();
    }
}
