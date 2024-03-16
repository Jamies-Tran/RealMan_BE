package com.capstone.realmen.dto.service.barber.branch;

import lombok.Builder;

@Builder
public record ServiceBranch(
        Long branchServiceId,
        String branchName,
        String branchThumbnail,
        Long branchServicePrice) {
}
