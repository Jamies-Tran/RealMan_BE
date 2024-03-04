package com.capstone.realmen.controller.list.service.barber;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.list.service.barber.models.BarberServiceListModelResponseMapper;
import com.capstone.realmen.controller.list.service.barber.models.BarberServiceListResponse;
import com.capstone.realmen.dto.service.barber.BarberServiceSearchCriteria;
import com.capstone.realmen.service.service.barber.BarberServiceUseCaseService;
import com.capstone.realmen.util.request.PageRequestCustom;
import com.capstone.realmen.util.request.SortCustom;
import com.capstone.realmen.util.response.ListResponse;

import jakarta.validation.constraints.Min;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BarberServiceListController implements BarberServiceListAPI {
    @NonNull
    private final BarberServiceUseCaseService barberServiceUseCaseService;
    @NonNull
    private final BarberServiceListModelResponseMapper responseMapper;

    @Override
    public ListResponse<BarberServiceListResponse> getBarberServiceList(String search, Long branchId,
            String sorter, @Min(1) Integer current, Integer pageSize) {
        PageRequestCustom pageRequestCustom = PageRequestCustom.of(current, pageSize, SortCustom.of(sorter));
        BarberServiceSearchCriteria searchCriteria = BarberServiceSearchCriteria.builder()
                .search(search)
                .branchId(branchId)
                .build();
        List<BarberServiceListResponse> responses = barberServiceUseCaseService
                .getBarberServiceList(searchCriteria, pageRequestCustom)
                .stream().map(responseMapper::toModel).toList();
        return new ListResponse<>(responses);
    }

}
