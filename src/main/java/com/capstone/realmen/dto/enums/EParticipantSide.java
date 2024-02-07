package com.capstone.realmen.dto.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EParticipantSide {
    BARBER(1),
    CUSTOMER(2);

    private final Integer value;
}
