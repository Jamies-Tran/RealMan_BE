package com.capstone.realmen.dto.branch.service;

import lombok.Builder;

@Builder
public record BranchService(
        Long branchServiceId,
        Long branchId,
        Long barberServiceId,
        Long branchServicePrice) {
}
