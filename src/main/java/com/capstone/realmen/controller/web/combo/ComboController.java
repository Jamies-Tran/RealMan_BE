package com.capstone.realmen.controller.web.combo;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.web.combo.models.ComboModelResponseMapper;
import com.capstone.realmen.controller.web.combo.models.ComboResponse;
import com.capstone.realmen.dto.combo.Combo;
import com.capstone.realmen.service.combo.ComboUseCaseService;
import com.capstone.realmen.util.response.ValueResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ComboController implements ComboAPI {
    @NonNull
    private final ComboUseCaseService comboUseCaseService;
    @NonNull
    private final ComboModelResponseMapper responseMapper;

    @Override
    public ValueResponse<ComboResponse> findById(Long comboId) {
        Combo foundCombo = comboUseCaseService.findById(comboId);
        return new ValueResponse<>(responseMapper.toModel(foundCombo));
    }
}
