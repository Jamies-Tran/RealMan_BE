package com.capstone.realmen.service.service.barber;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.capstone.realmen.controller.error.exceptions.ResourceNotFoundException;
import com.capstone.realmen.dto.service.barber.BarberService;
import com.capstone.realmen.dto.service.barber.BarberServiceMapper;
import com.capstone.realmen.dto.service.barber.BarberServiceSearchCriteria;
import com.capstone.realmen.dto.service.barber.branch.ServiceBranch;
import com.capstone.realmen.dto.service.barber.branch.ServiceBranchSearchCriteria;
import com.capstone.realmen.dto.service.barber.display.BarberServiceDisplay;
import com.capstone.realmen.info.service.barber.BarberServiceInfo;
import com.capstone.realmen.info.service.barber.BarberServiceInfoMapper;
import com.capstone.realmen.repository.database.service.barber.BarberServiceRepository;
import com.capstone.realmen.service.service.barber.display.BarberServiceDisplayQueryService;
import com.capstone.realmen.util.request.PageRequestCustom;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BarberServiceQueryService {
    @NonNull
    private final BarberServiceRepository barberServiceRepository;
    @NonNull
    private final BarberServiceDisplayQueryService displayQueryService;
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
        List<BarberServiceDisplay> displays = displayQueryService.findAllByBarberServiceId(barberServiceId); 
        return barberServiceInfoMapper.toDto(foundBarberService, displays);
    }

    public List<BarberService> getBarberServiceList(BarberServiceSearchCriteria searchCriteria, PageRequestCustom pageRequestCustom) {
        return barberServiceRepository.findAllInfo(searchCriteria.toLowerCase(), pageRequestCustom.pageRequest())
            .stream().map(barberServiceInfoMapper::toDto).toList();
    }

    public List<BarberService> findByComboId(Long comboId) {
        List<BarberService> barberServices = barberServiceRepository.findAllByComboId(comboId)
            .stream().map(barberServiceMapper::toDto).toList();
        return barberServices;
    }

    public Page<ServiceBranch> pageServiceBranch(Long barberServiceId, ServiceBranchSearchCriteria searchCriteria, PageRequestCustom pageRequestCustom) {
        Page<ServiceBranch> serviceBranches = barberServiceRepository.pageServiceBranch(barberServiceId, searchCriteria.toLowerCase(), pageRequestCustom.pageRequest())
            .map(barberServiceInfoMapper::convertServiceBranch);
        return serviceBranches;
    }
}
