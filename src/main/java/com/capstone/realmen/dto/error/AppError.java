package com.capstone.realmen.dto.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum AppError {
    NOT_FOUND("RM001", "Thông tin cần tìm kiếm không tồn tại"),
    JWT_INVALID("RM002", "Thông tin đăng nhập không hợp lệ"),
    INVALID_REQUEST("RM003", "Yêu cầu không hợp lệ"),
    ACCOUNT_INVALID("RM004", "Thông tin tài khoản không hợp lệ"),
    ACCOUNT_DUPLICATED("RM005", "Tài khoản đã tồn tại trên hệ thống"),
    WRONG_OTP_CHANGE_PASS("RM006", "OTP không đúng"),
    INVALID_SORT("RM007", "Thông tin sắp xếp không hợp lệ");

    final String code;
    final String message;
}
