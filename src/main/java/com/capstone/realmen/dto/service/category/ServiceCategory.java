package com.capstone.realmen.dto.service.category;

import java.util.List;

import com.capstone.realmen.dto.service.barber.BarberService;

import lombok.Builder;

@Builder
public record ServiceCategory(
    Long serviceCategoryId,
    String serviceCategoryCode,
    String serviceCategoryName,
    List<BarberService> barberServices
) {
}
