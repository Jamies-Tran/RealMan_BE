package com.capstone.realmen.controller.web.branch.models;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record BranchDisplayRequest(
    @NotNull String branchDisplayContent
) {
    
}
