package com.capstone.realmen.controller.web.branch.models;

import lombok.Builder;

@Builder
public record BarberServiceResponseV2(
    Long barberServiceId,
    String barberServiceName,
    String barberServiceThumbnail,
    Long barberServicePrice
) {
    
}
