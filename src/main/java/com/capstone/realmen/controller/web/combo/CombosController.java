package com.capstone.realmen.controller.web.combo;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.web.combo.models.ComboModelRequestMapper;
import com.capstone.realmen.controller.web.combo.models.ComboModelResponseMapper;
import com.capstone.realmen.controller.web.combo.models.ComboRequest;
import com.capstone.realmen.controller.web.combo.models.ComboResponse;
import com.capstone.realmen.dto.combo.Combo;
import com.capstone.realmen.dto.combo.ComboSearchCriteria;
import com.capstone.realmen.service.combo.ComboUseCaseService;
import com.capstone.realmen.util.request.PageRequestCustom;
import com.capstone.realmen.util.request.SortCustom;
import com.capstone.realmen.util.response.PageResponse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CombosController implements CombosAPI {
    @NonNull
    private final ComboUseCaseService comboUseCaseService;
    @NonNull
    private final ComboModelRequestMapper requestMapper;
    @NonNull
    private final ComboModelResponseMapper responseMapper;

    @Override
    public void save(@Valid ComboRequest comboRequest) {
        Combo combo = requestMapper.toDto(comboRequest);
        comboUseCaseService.save(combo);
    }

    @Override
    public PageResponse<ComboResponse> pageAll(String search, Long branchId, Long priceFrom, Long priceTo,
            String sorter,
            @Min(1) Integer current, Integer pageSize) {
        PageRequestCustom pageRequestCustom = PageRequestCustom.of(current, pageSize, SortCustom.of(sorter));
        ComboSearchCriteria searchCriteria = ComboSearchCriteria.builder()
                .search(search)
                .branchId(branchId)
                .priceFrom(priceFrom)
                .priceTo(priceTo)
                .build();
        Page<ComboResponse> responses = comboUseCaseService.pageAll(searchCriteria, pageRequestCustom)
                .map(responseMapper::toModel);
        return new PageResponse<>(responses.getContent(), responses.getTotalElements(), responses.getTotalPages(),
                pageRequestCustom.current(), pageSize);
    }

}
