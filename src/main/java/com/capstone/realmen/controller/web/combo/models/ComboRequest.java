package com.capstone.realmen.controller.web.combo.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

import com.capstone.realmen.controller.web.combo.models.service.ComboServiceRequest;

import lombok.Builder;

@Builder
public record ComboRequest(
                @NotNull String comboName,
                @NotNull Long branchId,
                @NotNull Long comboPrice,
                @Size(min = 1) List<ComboServiceRequest> barberServices) {
}
