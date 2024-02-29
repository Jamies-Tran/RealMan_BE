package com.capstone.realmen.controller.web.service.barber.models;

import com.capstone.realmen.util.constraints.DefaultText;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record BarberServiceRequest(
        Long serviceCategoryId,
        @DefaultText String barberServiceName,
        @NotNull @Min(15000) Long barberServicePrice) {

}
