package com.capstone.realmen.controller.mobile.combo;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.mobile.combo.models.ComboMobModelResponseMapper;
import com.capstone.realmen.controller.mobile.combo.models.ComboMobResponse;
import com.capstone.realmen.dto.combo.Combo;
import com.capstone.realmen.service.combo.ComboUseCaseService;
import com.capstone.realmen.util.response.ValueResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ComboMobController implements ComboMobAPI {
    @NonNull
    private final ComboUseCaseService comboUseCaseService;
    @NonNull
    private final ComboMobModelResponseMapper responseMapper;

    @Override
    public ValueResponse<ComboMobResponse> findById(Long comboId) {
        Combo foundCombo = comboUseCaseService.findById(comboId);
        return new ValueResponse<>(responseMapper.toModel(foundCombo));
    }
}
