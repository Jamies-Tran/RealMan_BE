package com.capstone.realmen.controller.web.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.realmen.controller.web.auth.models.LoginRequest;
import com.capstone.realmen.controller.web.auth.models.LoginResponse;
import com.capstone.realmen.util.response.ValueResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "MOB-Authentication", description = "Authentication API")
@RequestMapping("/web/auth")
public interface AuthAPI {
    @PostMapping
    ValueResponse<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest);
}
