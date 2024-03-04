package com.capstone.realmen.controller.web.combo.models.service;

import lombok.Builder;

@Builder
public record ComboServiceResponse(
        Long barberServiceId,
        String barberServiceName,
        String thumbnail,
        Long barberServicePrice) {
}
