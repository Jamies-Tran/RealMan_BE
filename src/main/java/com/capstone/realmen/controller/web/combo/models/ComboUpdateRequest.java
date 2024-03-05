package com.capstone.realmen.controller.web.combo.models;

import java.util.List;

import com.capstone.realmen.controller.web.combo.models.service.ComboServiceRequest;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record ComboUpdateRequest(
        @NotNull String comboName,
        @NotNull Long comboPrice,
        @Size(min = 1) List<ComboServiceRequest> barberServices) {

}
