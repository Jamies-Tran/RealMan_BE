package com.capstone.realmen.controller.list.service.barber.models;

import lombok.Builder;

@Builder
public record BarberServiceListResponse(
    Long barberServiceId,
    String barberServiceName,
    Long barberServicePrice
) {
}
