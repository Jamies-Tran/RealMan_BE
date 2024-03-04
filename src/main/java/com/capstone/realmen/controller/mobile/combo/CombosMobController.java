package com.capstone.realmen.controller.mobile.combo;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.mobile.combo.models.ComboMobModelResponseMapper;
import com.capstone.realmen.controller.mobile.combo.models.ComboMobResponse;
import com.capstone.realmen.dto.combo.ComboSearchCriteria;
import com.capstone.realmen.service.combo.ComboUseCaseService;
import com.capstone.realmen.util.request.PageRequestCustom;
import com.capstone.realmen.util.request.SortCustom;
import com.capstone.realmen.util.response.PageResponse;

import jakarta.validation.constraints.Min;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CombosMobController implements CombosMobAPI {
    @NonNull
    private final ComboUseCaseService comboUseCaseService;
    @NonNull
    private final ComboMobModelResponseMapper responseMapper;

    @Override
    public PageResponse<ComboMobResponse> pageAll(String search, Long branchId, Long priceFrom, Long priceTo,
            String sorter,
            @Min(1) Integer current, Integer pageSize) {
        PageRequestCustom pageRequestCustom = PageRequestCustom.of(current, pageSize, SortCustom.of(sorter));
        ComboSearchCriteria searchCriteria = ComboSearchCriteria.builder()
                .search(search)
                .branchId(branchId)
                .priceFrom(priceFrom)
                .priceTo(priceTo)
                .build();
        Page<ComboMobResponse> responses = comboUseCaseService.pageAll(searchCriteria, pageRequestCustom)
                .map(responseMapper::toModel);
        return new PageResponse<>(responses.getContent(), responses.getTotalElements(), responses.getTotalPages(),
                pageRequestCustom.current(), pageSize);
    }
    
}
