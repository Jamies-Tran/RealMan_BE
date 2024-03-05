package com.capstone.realmen.service.combo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capstone.realmen.controller.error.exceptions.ResourceNotFoundException;
import com.capstone.realmen.dto.auditable.Auditable;
import com.capstone.realmen.dto.combo.Combo;
import com.capstone.realmen.dto.combo.ComboMapper;
import com.capstone.realmen.dto.service.barber.BarberService;
import com.capstone.realmen.repository.database.combo.ComboEntity;
import com.capstone.realmen.repository.database.combo.ComboRepository;
import com.capstone.realmen.service.combo.service.ComboServiceCommandService;
import com.capstone.realmen.util.RequestContext;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComboCommandService {
        @NonNull
        private final ComboRepository comboRepository;
        @NonNull
        private final ComboServiceCommandService comboServiceCommandService;
        @NonNull
        private final ComboMapper comboMapper;
        @NonNull
        private final RequestContext requestContext;

        public void save(Combo combo) {
                ComboEntity saveCombo = comboMapper
                                .create(combo, Auditable.of(requestContext.getAccountId().toString()));
                ComboEntity savedCombo = comboRepository.save(saveCombo);
                List<Long> barberServiceIds = combo.barberServices()
                                .stream().map(BarberService::barberServiceId).toList();
                comboServiceCommandService.saveAll(savedCombo.getComboId(), barberServiceIds);
        }

    public void update(Long comboId, Combo combo) {
        ComboEntity foundCombo = comboRepository.findById(comboId)
                .orElseThrow(ResourceNotFoundException::new);
        comboMapper.update(foundCombo, combo,
                Auditable.updateEntity(foundCombo, requestContext.getAccountId().toString()));
        List<Long> barberServiceIds = combo.barberServices().stream().map(BarberService::barberServiceId).toList();        
        comboServiceCommandService.updateComboService(foundCombo.getComboId(), barberServiceIds);
        comboRepository.save(foundCombo);
    }
}
