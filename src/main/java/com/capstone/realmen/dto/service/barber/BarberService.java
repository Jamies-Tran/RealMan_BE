package com.capstone.realmen.dto.service.barber;

import lombok.Builder;
import java.util.List;

import com.capstone.realmen.dto.service.barber.display.BarberServiceDisplay;

@Builder
public record BarberService(
        Long barberServiceId,
        Long serviceCategoryId,
        Long branchId,
        String branchName,
        String serviceCategoryName,
        String barberServiceName,
        String barberServiceThumbnail,
        List<BarberServiceDisplay> barberServiceDisplays,
        Long barberServicePrice) {
}
