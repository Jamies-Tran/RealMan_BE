package com.capstone.realmen.controller.mobile.combo.models.service;

import lombok.Builder;

@Builder
public record ComboServiceMobResponse(
        Long barberServiceId,
        String barberServiceName,
        String thumbnail,
        Long barberServicePrice) {
}
