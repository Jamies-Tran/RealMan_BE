package com.capstone.realmen.controller.web.service.barber;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.web.service.barber.models.BarberServiceModelRequestMapping;
import com.capstone.realmen.controller.web.service.barber.models.BarberServiceModelResponseMapper;
import com.capstone.realmen.controller.web.service.barber.models.BarberServiceRequest;
import com.capstone.realmen.controller.web.service.barber.models.BarberServiceResponse;
import com.capstone.realmen.controller.web.service.barber.models.branch.ServiceBranchResponse;
import com.capstone.realmen.dto.service.barber.BarberService;
import com.capstone.realmen.dto.service.barber.branch.ServiceBranchSearchCriteria;
import com.capstone.realmen.service.service.barber.BarberServiceUseCaseService;
import com.capstone.realmen.util.request.PageRequestCustom;
import com.capstone.realmen.util.request.SortCustom;
import com.capstone.realmen.util.response.PageResponse;
import com.capstone.realmen.util.response.ValueResponse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BarberServiceController implements BarberServiceAPI {
    @NonNull
    private final BarberServiceUseCaseService barberServiceUseCaseService;
    @NonNull
    private final BarberServiceModelResponseMapper responseMapper;
    @NonNull
    private final BarberServiceModelRequestMapping requestMapping;

    @Override
    public ValueResponse<BarberServiceResponse> findById(Long barberServiceId) {
        BarberService foundBarberService = barberServiceUseCaseService.findById(barberServiceId);
        return new ValueResponse<>(responseMapper.toModel(foundBarberService));
    }

    @Override
    public void update(Long barberServiceId, @Valid BarberServiceRequest barberServiceRequest) {
        barberServiceUseCaseService.update(barberServiceId, requestMapping.toDto(barberServiceRequest));
    }

    @Override
    public void delete(Long barberServiceId) {
        barberServiceUseCaseService.delete(barberServiceId);
    }

    @Override
    public PageResponse<ServiceBranchResponse> pageServiceBranch(Long barberServiceId, String search, Long priceFrom,
            Long priceTo, String sorter, @Min(1) Integer current, Integer pageSize) {
        PageRequestCustom pageRequestCustom = PageRequestCustom.of(current, pageSize, SortCustom.of(sorter));
        ServiceBranchSearchCriteria searchCriteria = ServiceBranchSearchCriteria.builder()
                .search(search)
                .priceFrom(priceFrom)
                .priceTo(priceTo)
                .build();
        Page<ServiceBranchResponse> responses = barberServiceUseCaseService
                .pageServiceBranch(barberServiceId, searchCriteria, pageRequestCustom)
                .map(responseMapper::convertModel);
        return new PageResponse<>(responses.getContent(), responses.getTotalElements(), responses.getTotalPages(),
                pageRequestCustom.current(), pageSize);
    }

}
