package com.capstone.realmen.controller.web.branch.models;

import lombok.Builder;

@Builder
public record BranchServiceResponse(
        Long branchServiceId,
        BranchResponseV2 branch,
        BarberServiceResponseV2 barberService) {

}
