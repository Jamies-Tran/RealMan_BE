package com.capstone.realmen.controller.web.service.barber.models;

import java.util.List;

import com.capstone.realmen.controller.web.service.barber.models.display.BarberServiceDisplayResponse;

import lombok.Builder;

@Builder
public record BarberServiceResponse(
                Long barberServiceId,
                Long serviceCategoryId,
                Long branchId,
                String branchName,
                String serviceCategoryName,
                String barberServiceName,
                String barberServiceThumbnail,
                List<BarberServiceDisplayResponse> barberServiceDisplays,
                Long barberServicePrice) {
}
