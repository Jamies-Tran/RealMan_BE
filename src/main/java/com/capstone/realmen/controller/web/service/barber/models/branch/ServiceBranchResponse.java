package com.capstone.realmen.controller.web.service.barber.models.branch;

import lombok.Builder;

@Builder
public record ServiceBranchResponse(
        Long branchServiceId,
        String branchName,
        String branchThumbnail,
        Long branchServicePrice) {

}
