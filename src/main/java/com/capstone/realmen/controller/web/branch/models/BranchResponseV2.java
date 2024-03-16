package com.capstone.realmen.controller.web.branch.models;

import lombok.Builder;

@Builder
public record BranchResponseV2(
    Long branchId,
    String branchThumbnail,
    String branchName,
    String branchStreet,
    String branchWard,
    String branchDistrict,
    String branchProvince,
    Long branchServicePrice
) {
    
}
