package com.capstone.realmen.controller.web.combo.models;

import java.util.List;

import com.capstone.realmen.controller.web.combo.models.service.ComboServiceResponse;

import lombok.Builder;

@Builder
public record ComboResponse(
        Long comboId,
        Long branchId,
        String comboName,
        Long comboPrice,
        List<ComboServiceResponse> barberServices) {

}
