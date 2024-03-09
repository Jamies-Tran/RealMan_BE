package com.capstone.realmen.dto.combo;

import java.util.List;

import com.capstone.realmen.dto.service.barber.BarberService;

import lombok.Builder;

@Builder
public record Combo(
    Long comboId,
    Long branchId,
    String branchName,
    String comboName,
    Long comboPrice,
    List<BarberService> barberServices
) {
}
