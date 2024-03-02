package com.capstone.realmen.controller.web.service.barber.models;

import java.util.List;

import com.capstone.realmen.controller.web.service.barber.models.display.BarberServiceDisplayResponse;

import lombok.Builder;

@Builder
public record BarberServiceResponse(
                Long barberServiceId,
                String serviceCategoryName,
                String barberServiceName,
                String thumbnail,
                List<BarberServiceDisplayResponse> barberServiceDisplays,
                Long barberServicePrice) {
}
