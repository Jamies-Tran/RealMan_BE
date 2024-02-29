package com.capstone.realmen.controller.mobile.service.barber;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.mobile.service.barber.models.BarberServiceMobResponse;
import com.capstone.realmen.controller.mobile.service.barber.models.BarberServiceMobResponseModelMapper;
import com.capstone.realmen.dto.service.barber.BarberServiceSearchCriteria;
import com.capstone.realmen.service.service.barber.BarberServiceUseCaseService;
import com.capstone.realmen.util.request.PageRequestCustom;
import com.capstone.realmen.util.request.SortCustom;
import com.capstone.realmen.util.response.PageResponse;

import jakarta.validation.constraints.Min;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BarberServicesMobController implements BarberServicesMobAPI {
    @NonNull
    private final BarberServiceUseCaseService barberServiceUseCaseService;
    @NonNull
    private final BarberServiceMobResponseModelMapper resposneMapper;

    @Override
    public PageResponse<BarberServiceMobResponse> pageAll(Long serviceCategoryId, String search, Long priceFrom,
            Long priceTo, String sorter,
            @Min(1) Integer current, Integer pageSize) {
        PageRequestCustom pageRequestCustom = PageRequestCustom.of(current, pageSize, SortCustom.of(sorter));
        BarberServiceSearchCriteria searchCriteria = BarberServiceSearchCriteria.builder()
                .search(search)
                .priceFrom(priceFrom)
                .priceTo(priceTo)
                .build();
        Page<BarberServiceMobResponse> resposnes = barberServiceUseCaseService
                .pageByServiceCategoryId(serviceCategoryId, searchCriteria, pageRequestCustom)
                .map(resposneMapper::toModel);
        return new PageResponse<>(resposnes.getContent(), resposnes.getTotalElements(), resposnes.getTotalPages(),
                pageRequestCustom.current(), pageSize);
    }
}
