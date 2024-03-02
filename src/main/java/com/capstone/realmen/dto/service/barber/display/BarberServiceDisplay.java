package com.capstone.realmen.dto.service.barber.display;

import lombok.Builder;

@Builder
public record BarberServiceDisplay(
    Long barberServiceDisplayId,
    Long barberServiceId,
    String barberServiceDisplayContent
) {
}
