package com.capstone.realmen.dto.branch.display;

import lombok.Builder;

@Builder
public record BranchDisplay(
    Long branchDisplayId,
    Long branchId,
    String branchDisplayContent
) {
    
}
