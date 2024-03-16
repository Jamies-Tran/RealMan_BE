package com.capstone.realmen.controller.web.branch.models;

import jakarta.validation.constraints.NotNull;

public record BranchServicePriceUpdateRequest(
    @NotNull Long branchServicePrice
) {
    
}
