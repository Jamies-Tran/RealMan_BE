package com.capstone.realmen.controller.web.service.barber.models.display;

import lombok.Builder;

@Builder
public record BarberServiceDisplayResponse(
        Long barberServiceDisplayId,
        String barberServiceDisplayContent) {
}
