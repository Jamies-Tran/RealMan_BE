package com.capstone.realmen.service.combo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capstone.realmen.dto.combo.Combo;
import com.capstone.realmen.dto.combo.ComboSearchCriteria;
import com.capstone.realmen.util.request.PageRequestCustom;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComboUseCaseService {
    @NonNull
    private final ComboCommandService commandService;
    @NonNull
    private final ComboQueryService queryService;

    @Transactional
    public void save(Combo combo) {
        commandService.save(combo);
    }

    @Transactional
    public void update(Long comboId, Combo combo) {
        commandService.update(comboId, combo);
    }

    @Transactional
    public void delete(Long comboId) {
        commandService.delete(comboId);
    }

    public Combo findById(Long comboId) {
        return queryService.findById(comboId);
    }

    public Page<Combo> pageAll(ComboSearchCriteria searchCriteria, PageRequestCustom pageRequestCustom) {
        return queryService.pageAll(searchCriteria, pageRequestCustom);
    }

    public List<Combo> getComboList(ComboSearchCriteria searchCriteria, PageRequestCustom pageRequestCustom) {
        return queryService.getComboList(searchCriteria, pageRequestCustom);
    }
}
