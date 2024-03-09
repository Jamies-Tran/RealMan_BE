package com.capstone.realmen.controller.mobile.combo.models;

import java.util.List;

import com.capstone.realmen.controller.mobile.combo.models.service.ComboServiceMobResponse;

import lombok.Builder;

@Builder
public record ComboMobResponse(
        Long comboId,
        Long branchId,
        String branchName,
        String comboName,
        Long comboPrice,
        List<ComboServiceMobResponse> barberServices) {

}
