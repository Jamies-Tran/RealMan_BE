package com.capstone.realmen.dto.branch;

import java.time.LocalTime;
import java.util.List;
import com.capstone.realmen.dto.branch.display.BranchDisplay;
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
                List<Long> barberServiceIds,
                List<Long> comboIds) {

}
