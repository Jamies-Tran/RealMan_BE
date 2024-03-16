package com.capstone.realmen.controller.web.service.barber.models;

import java.util.List;

import com.capstone.realmen.controller.web.service.barber.models.display.BarberServiceDisplayRequest;
import com.capstone.realmen.util.constraints.DefaultText;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record BarberServiceRequest(
        Long serviceCategoryId,
        @NotNull String barberServiceThumbnail,
        @DefaultText String barberServiceName,
        @Size(min = 1) List<BarberServiceDisplayRequest> barberServiceDisplays,
        @NotNull @Min(15000) Long barberServicePrice) {

}
