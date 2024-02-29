package com.capstone.realmen.service.service.barber;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.capstone.realmen.controller.error.exceptions.ResourceNotFoundException;
import com.capstone.realmen.dto.service.barber.BarberService;
import com.capstone.realmen.dto.service.barber.BarberServiceMapper;
import com.capstone.realmen.dto.service.barber.BarberServiceSearchCriteria;
import com.capstone.realmen.info.service.barber.BarberServiceInfo;
import com.capstone.realmen.info.service.barber.BarberServiceInfoMapper;
import com.capstone.realmen.repository.database.service.barber.BarberServiceRepository;
import com.capstone.realmen.util.request.PageRequestCustom;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BarberServiceQueryService {
    @NonNull
    private final BarberServiceRepository barberServiceRepository;
    @NonNull
    private final BarberServiceMapper barberServiceMapper;
    @NonNull
    private final BarberServiceInfoMapper barberServiceInfoMapper;

    public Page<BarberService> pageByServiceCategoryId(Long serviceCategoryId,
            BarberServiceSearchCriteria searchCriteria, PageRequestCustom pageRequestCustom) {
        Page<BarberService> barberServices = barberServiceRepository
                .pageByServiceCategoryId(serviceCategoryId, searchCriteria, pageRequestCustom.pageRequest())
                .map(barberServiceInfoMapper::toDto);
        return barberServices;
    }

    public BarberService findById(Long barberServiceId) {
        BarberServiceInfo foundBarberService = barberServiceRepository.findInfoById(barberServiceId)
                .orElseThrow(ResourceNotFoundException::new);
        return barberServiceInfoMapper.toDto(foundBarberService);
    }
}
