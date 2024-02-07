package com.capstone.realmen.dto.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EGender {
    MALE("nam"),
    FEMALE("nữ");

    private final String text;
}
