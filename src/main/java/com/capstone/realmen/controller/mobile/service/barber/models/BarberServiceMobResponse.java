package com.capstone.realmen.controller.mobile.service.barber.models;

import lombok.Builder;
import java.util.List;

import com.capstone.realmen.controller.web.service.barber.models.display.BarberServiceDisplayResponse;

@Builder
public record BarberServiceMobResponse(
        Long barberServiceId,
        Long serviceCategoryId,
        String barberServiceThumbnail,
        Long branchId,
        String branchName,
        String serviceCategoryName,
        String barberServiceName,
        List<BarberServiceDisplayResponse> barberServiceDisplays,
        Long barberServicePrice) {

}
