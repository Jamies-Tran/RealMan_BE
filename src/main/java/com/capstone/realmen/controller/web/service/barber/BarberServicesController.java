package com.capstone.realmen.controller.web.service.barber;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;
import com.capstone.realmen.controller.web.service.barber.models.BarberServiceRequest;
import com.capstone.realmen.controller.web.service.barber.models.BarberServiceResponse;
import com.capstone.realmen.controller.web.service.barber.models.BarberServiceModelRequestMapping;
import com.capstone.realmen.controller.web.service.barber.models.BarberServiceModelResponseMapper;
import com.capstone.realmen.dto.service.barber.BarberService;
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
public class BarberServicesController implements BarberServicesAPI {
    @NonNull
    private final BarberServiceUseCaseService barberServiceUseCaseService;
    @NonNull
    private final BarberServiceModelRequestMapping barberServiceRequestMapping;
    @NonNull
    private final BarberServiceModelResponseMapper barberServiceModelResponseMapper;

    @Override
    public void save(BarberServiceRequest barberServiceRequest) {
        BarberService barberService = barberServiceRequestMapping.toDto(barberServiceRequest);
        barberServiceUseCaseService.save(barberService);
    }

    @Override
    public PageResponse<BarberServiceResponse> pageByServiceCategoryId(Long categoryId, Long branchId, String search, Long priceFrom,
            Long priceTo, String sorter, @Min(1) Integer current, Integer pageSize) {
        PageRequestCustom pageRequestCustom = PageRequestCustom.of(current, pageSize, SortCustom.of(sorter));
        BarberServiceSearchCriteria searchCriteria = BarberServiceSearchCriteria.builder()
            .search(search)
            .branchId(branchId)
            .priceFrom(priceFrom)
            .priceTo(priceTo)
            .build();
        Page<BarberServiceResponse> barberServices = barberServiceUseCaseService.pageByServiceCategoryId(categoryId, searchCriteria, pageRequestCustom)
                .map(barberServiceModelResponseMapper::toModel);
        return new PageResponse<>(
            barberServices.getContent(),
            barberServices.getTotalElements(),
            barberServices.getTotalPages(),
            pageRequestCustom.current(),
            barberServices.getPageable().getPageSize()
        );
    }
}
