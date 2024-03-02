package com.capstone.realmen.service.service.barber;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.realmen.dto.service.barber.BarberService;
import com.capstone.realmen.dto.service.barber.BarberServiceSearchCriteria;
import com.capstone.realmen.util.request.PageRequestCustom;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BarberServiceUseCaseService {
    @NonNull
    private final BarberServiceCommandService barberServiceCommandService;
    @NonNull
    private final BarberServiceQueryService barberServiceQueryService;

    @Transactional
    public void save(BarberService barberService) {
        barberServiceCommandService.save(barberService);
    }

    @Transactional
    public void update(Long barberServiceId, BarberService barberService) {
        barberServiceCommandService.update(barberServiceId, barberService);
    }

    @Transactional
    public void delete(Long barberServiceId) {
        barberServiceCommandService.delete(barberServiceId);
    }

    public Page<BarberService> pageByServiceCategoryId(Long serviceCategoryId,
            BarberServiceSearchCriteria searchCriteria, PageRequestCustom pageRequestCustom) {
        return barberServiceQueryService.pageByServiceCategoryId(serviceCategoryId, searchCriteria, pageRequestCustom);
    }

    public BarberService findById(Long barberServiceId) {
        return barberServiceQueryService.findById(barberServiceId);
    }
}
