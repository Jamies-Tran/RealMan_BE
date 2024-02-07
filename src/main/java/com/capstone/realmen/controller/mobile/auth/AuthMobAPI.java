package com.capstone.realmen.controller.mobile.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.realmen.controller.mobile.auth.models.LoginMobRequest;
import com.capstone.realmen.controller.mobile.auth.models.LoginMobResponse;
import com.capstone.realmen.util.response.ValueResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Authentication", description = "Authentication API")
@RequestMapping("/mobile/auth")
public interface AuthMobAPI {
    @PostMapping("/create-otp")
    void createOTP(String phone);

    @PostMapping
    public ValueResponse<LoginMobResponse> login(@RequestBody @Valid LoginMobRequest loginMobRequest);
}
