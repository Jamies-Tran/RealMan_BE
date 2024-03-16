package com.capstone.realmen.dto.branch.service;

import lombok.Builder;

@Builder
public record BranchService(
                Long branchServiceId,
                Long branchId,
                Long barberServiceId,
                Long branchServicePrice,
                String branchName,
                String branchStreet,
                String branchWard,
                String branchDistrict,
                String branchProvince,
                String branchThumbnail,
                Long barberServicePrice,
                String barberServiceName,
                String barberServiceThumbnail) {
}
