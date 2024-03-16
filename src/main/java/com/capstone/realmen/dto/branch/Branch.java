package com.capstone.realmen.dto.branch;

import java.time.LocalTime;
import java.util.List;
import com.capstone.realmen.dto.branch.display.BranchDisplay;
import com.capstone.realmen.dto.branch.service.BranchService;

import lombok.Builder;

@Builder
public record Branch(
                Long branchId,
                String branchName,
                String branchThumbnail,
                String branchAddress,
                String branchStreet,
                String branchWard,
                String branchDistrict,
                String branchProvince,
                Double latitude,
                Double longitude,
                LocalTime open,
                LocalTime close,
                List<BranchDisplay> branchDisplays,
                List<BranchService> branchServices,
                Double distance,
                List<Long> comboIds) {

}
