package com.capstone.realmen.controller.mobile.branch.models;

import java.time.LocalTime;

public record BranchMobResponse(
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
        Double distance) {

}
