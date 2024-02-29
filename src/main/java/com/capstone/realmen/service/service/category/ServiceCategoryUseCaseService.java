package com.capstone.realmen.service.service.category;

import java.util.List;
import org.springframework.stereotype.Service;
import com.capstone.realmen.dto.service.category.ServiceCategory;
import com.capstone.realmen.dto.service.category.ServiceCategorySearchCriteria;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceCategoryUseCaseService {
    @NonNull
    private ServiceCategoryQueryService serviceCategoryQueryService;


    public ServiceCategory findById(Long serviceCategoryId) {
        return serviceCategoryQueryService.findById(serviceCategoryId);
    } 

    public List<ServiceCategory> findAll(ServiceCategorySearchCriteria searchCriteria) {
        return serviceCategoryQueryService.findAll(searchCriteria);
    }
}
