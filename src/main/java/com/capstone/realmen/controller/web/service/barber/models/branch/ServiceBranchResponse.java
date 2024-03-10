package com.capstone.realmen.controller.web.service.barber.models.branch;

import lombok.Builder;

@Builder
public record ServiceBranchResponse(
    Long barberServiceId,
    Long branchId,
    String branchName,
    String branchThumbnail,
    Long branchServicePrice
) {
    
}
