package com.capstone.realmen.controller.web.auth;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.web.auth.models.LoginRequest;
import com.capstone.realmen.controller.web.auth.models.LoginResponse;
import com.capstone.realmen.service.auth.AuthUseCaseService;
import com.capstone.realmen.util.response.ValueResponse;

import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthAPI {
    @NonNull
    private final AuthUseCaseService authUseCaseService;

    @Override
    public ValueResponse<LoginResponse> login(@Valid LoginRequest loginRequest) {
        LoginResponse loginResponse = authUseCaseService.loginWeb(loginRequest);
        return new ValueResponse<LoginResponse>(loginResponse);
    }

}
