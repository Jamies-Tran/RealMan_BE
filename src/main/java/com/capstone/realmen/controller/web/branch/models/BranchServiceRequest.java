package com.capstone.realmen.controller.web.branch.models;

import lombok.Builder;

@Builder
public record BranchServiceRequest(
    Long barberServiceId,
    Long branchServicePrice
) {
}
