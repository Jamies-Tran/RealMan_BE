package com.capstone.realmen.controller.web.combo;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.web.combo.models.ComboModelRequestMapper;
import com.capstone.realmen.controller.web.combo.models.ComboRequest;
import com.capstone.realmen.dto.combo.Combo;
import com.capstone.realmen.service.combo.ComboUseCaseService;

import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CombosController implements CombosAPI {
    @NonNull
    private final ComboUseCaseService comboUseCaseService;
    @NonNull
    private final ComboModelRequestMapper requestMapper;

    @Override
    public void save(@Valid ComboRequest comboRequest) {
        Combo combo = requestMapper.toDto(comboRequest);
        comboUseCaseService.save(combo);
    }

}
