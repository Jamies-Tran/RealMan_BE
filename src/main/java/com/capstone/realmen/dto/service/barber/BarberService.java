package com.capstone.realmen.dto.service.barber;

import lombok.Builder;

@Builder
public record BarberService(
        Long barberServiceId,
        Long serviceCategoryId,
        String serviceCategoryName,
        String barberServiceName,
        Long barberServicePrice) {
}
