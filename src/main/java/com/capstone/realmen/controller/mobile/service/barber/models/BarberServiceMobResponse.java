package com.capstone.realmen.controller.mobile.service.barber.models;

import lombok.Builder;

@Builder
public record BarberServiceMobResponse(
        Long barberServiceId,
        String serviceCategoryName,
        String barberServiceName,
        Long barberServicePrice) {

}
