package com.capstone.realmen.service.combo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capstone.realmen.dto.combo.Combo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComboUseCaseService {
    @NonNull
    private final ComboCommandService comboCommandService;

    @Transactional
    public void save(Combo combo) {
        comboCommandService.save(combo);
    }
}
