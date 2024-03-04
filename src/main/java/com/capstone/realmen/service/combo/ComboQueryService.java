package com.capstone.realmen.service.combo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.capstone.realmen.controller.error.exceptions.ResourceNotFoundException;
import com.capstone.realmen.dto.combo.Combo;
import com.capstone.realmen.dto.combo.ComboSearchCriteria;
import com.capstone.realmen.dto.service.barber.BarberService;
import com.capstone.realmen.info.combo.ComboInfo;
import com.capstone.realmen.info.combo.ComboInfoMapper;
import com.capstone.realmen.repository.database.combo.ComboRepository;
import com.capstone.realmen.service.service.barber.BarberServiceQueryService;
import com.capstone.realmen.util.request.PageRequestCustom;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComboQueryService {
    @NonNull
    private final ComboRepository comboRepository;
    @NonNull
    private final BarberServiceQueryService barberServiceQueryService;
    @NonNull
    private final ComboInfoMapper comboInfoMapper;

    public Combo findById(Long comboId) {
        ComboInfo foundCombo = comboRepository.findInfoById(comboId)
                .orElseThrow(ResourceNotFoundException::new);
        List<BarberService> barberServices = barberServiceQueryService.findByComboId(comboId);
        return comboInfoMapper.toDto(foundCombo, barberServices);
    }

    public Page<Combo> pageAll(ComboSearchCriteria searchCriteria, PageRequestCustom pageRequestCustom) {
        Page<Combo> combos = comboRepository.pageAllInfo(searchCriteria.toLowerCase(), pageRequestCustom.pageRequest())
            .map(comboInfoMapper::toDto);
        return combos;
    }
}
