package com.capstone.realmen.dto.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum AppError {
    NOT_FOUND("RM_404", "NOT_FOUND"),
    JWT_INVALID("RM_401", "INVALID_LOGIN"),
    INVALID_REQUEST("RM_400", "INVALID_REQUEST"),
    ACCOUNT_INVALID("RM_401_2", "INF_NOT_VALID"),
    ACCOUNT_DUPLICATED("RM_409", "ACCOUNT_DUPLICATED");

    final String code;
    final String message;
}
