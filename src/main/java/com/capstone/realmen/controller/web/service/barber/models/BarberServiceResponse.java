package com.capstone.realmen.controller.web.service.barber.models;

import lombok.Builder;

@Builder
public record BarberServiceResponse(
        Long barberServiceId,
        String serviceCategoryName,
        String barberServiceName,
        String thumbnail,
        Long barberServicePrice) {
}
