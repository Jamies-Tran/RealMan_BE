package com.capstone.realmen.controller.mobile.service.barber.models.display;

import lombok.Builder;

@Builder
public record BarberServiceDisplayMobResponse(
        Long barberServiceDisplayId,
        String barberServiceDisplayContent) {
}
