package com.capstone.realmen.controller.list.combo.models;

import lombok.Builder;

@Builder
public record ComboListResponse(
    Long comboId,
    String comboName,
    Long comboPrice
) {
    
}
