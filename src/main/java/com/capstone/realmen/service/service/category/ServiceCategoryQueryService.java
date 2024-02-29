package com.capstone.realmen.service.service.category;

import java.util.List;
import org.springframework.stereotype.Service;
import com.capstone.realmen.controller.error.exceptions.ResourceNotFoundException;
import com.capstone.realmen.dto.service.category.ServiceCategory;
import com.capstone.realmen.dto.service.category.ServiceCategorySearchCriteria;
import com.capstone.realmen.info.service.category.ServiceCategoryInfo;
import com.capstone.realmen.info.service.category.ServiceCategoryInfoMapper;
import com.capstone.realmen.repository.database.service.category.ServiceCategoryRepository;
import com.capstone.realmen.service.service.barber.BarberServiceQueryService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceCategoryQueryService {
    @NonNull
    private final ServiceCategoryRepository serviceCategoryRepository;
    @NonNull
    private final BarberServiceQueryService barberServiceQueryService;
    @NonNull
    private final ServiceCategoryInfoMapper serviceCategoryInfoMapper;

    public ServiceCategory findById(Long serviceCategoryId) {
        ServiceCategoryInfo foundServiceCategory = serviceCategoryRepository.findInfoById(serviceCategoryId)
                .orElseThrow(ResourceNotFoundException::new);
        return serviceCategoryInfoMapper.toDto(foundServiceCategory);
    }

    public List<ServiceCategory> findAll(ServiceCategorySearchCriteria searchCriteria) {
        return serviceCategoryRepository.findInfos(searchCriteria.toLowerCase()).stream()
                .map(serviceCategoryInfoMapper::toDto)
                .toList();
    }
}
