package com.capstone.realmen.controller.mobile.service.category;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.mobile.service.category.models.ServiceCategoryMobModelResponseMapper;
import com.capstone.realmen.controller.mobile.service.category.models.ServiceCategoryMobResponse;
import com.capstone.realmen.dto.service.category.ServiceCategory;
import com.capstone.realmen.service.service.category.ServiceCategoryUseCaseService;
import com.capstone.realmen.util.response.ValueResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ServiceCategoryMobController implements ServiceCategoryMobAPI {
    @NonNull
    private final ServiceCategoryUseCaseService serviceCategoryUseCaseService;
    @NonNull
    private final ServiceCategoryMobModelResponseMapper responseMapper;

    @Override
    public ValueResponse<ServiceCategoryMobResponse> findById(Long serviceCategoryId) {
        ServiceCategory foundServiceCategory = serviceCategoryUseCaseService.findById(serviceCategoryId);
        return new ValueResponse<>(responseMapper.toModel(foundServiceCategory));
    }
}
