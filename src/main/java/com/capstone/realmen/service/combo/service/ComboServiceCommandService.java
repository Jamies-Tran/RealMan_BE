package com.capstone.realmen.service.combo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capstone.realmen.repository.database.combo.service.ComboServiceEntity;
import com.capstone.realmen.repository.database.combo.service.ComboServiceRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComboServiceCommandService {
    @NonNull
    private final ComboServiceRepository comboServiceRepository;

    public void saveAll(Long comboId, List<Long> barberServiceIds) {
        List<ComboServiceEntity> comboServices = barberServiceIds.stream().map(barberServiceId -> {
            return ComboServiceEntity.builder()
                    .comboId(comboId)
                    .barberServiceId(barberServiceId)
                    .build();
        }).toList();
        comboServiceRepository.saveAll(comboServices);
    }

    public void deleteAllByComboId(Long comboId) {
        comboServiceRepository.deleteAllByComboId(comboId);
    }

    public void updateComboService(Long comboId, List<Long> barberServiceIds) {
        comboServiceRepository.deleteAllByComboId(comboId);
        List<ComboServiceEntity> comboServices = barberServiceIds.stream().map(barberServiceId -> {
            return ComboServiceEntity.builder()
                    .comboId(comboId)
                    .barberServiceId(barberServiceId)
                    .build();
        }).toList();
        comboServiceRepository.saveAll(comboServices);
    }
}
