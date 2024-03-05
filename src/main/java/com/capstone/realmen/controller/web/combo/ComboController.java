package com.capstone.realmen.controller.web.combo;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.web.combo.models.ComboModelRequestMapper;
import com.capstone.realmen.controller.web.combo.models.ComboModelResponseMapper;
import com.capstone.realmen.controller.web.combo.models.ComboResponse;
import com.capstone.realmen.controller.web.combo.models.ComboUpdateRequest;
import com.capstone.realmen.dto.combo.Combo;
import com.capstone.realmen.service.combo.ComboUseCaseService;
import com.capstone.realmen.util.response.ValueResponse;

import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ComboController implements ComboAPI {
    @NonNull
    private final ComboUseCaseService comboUseCaseService;
    @NonNull
    private final ComboModelResponseMapper responseMapper;
    @NonNull
    private final ComboModelRequestMapper requestMapper;

    @Override
    public ValueResponse<ComboResponse> findById(Long comboId) {
        Combo foundCombo = comboUseCaseService.findById(comboId);
        return new ValueResponse<>(responseMapper.toModel(foundCombo));
    }

    @Override
    public void update(Long comboId, @Valid ComboUpdateRequest comboRequest) {
        comboUseCaseService.update(comboId, requestMapper.toDto(comboRequest));
    }
}
