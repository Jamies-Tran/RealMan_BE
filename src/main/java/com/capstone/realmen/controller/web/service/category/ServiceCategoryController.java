package com.capstone.realmen.controller.web.service.category;

import org.springframework.web.bind.annotation.RestController;
import com.capstone.realmen.controller.web.service.category.models.ServiceCategoryModelResponseMapper;
import com.capstone.realmen.controller.web.service.category.models.ServiceCategoryResponse;
import com.capstone.realmen.dto.service.category.ServiceCategory;
import com.capstone.realmen.service.service.category.ServiceCategoryUseCaseService;
import com.capstone.realmen.util.response.ValueResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ServiceCategoryController implements ServiceCategoryAPI {
    @NonNull
    private final ServiceCategoryUseCaseService serviceCategoryUseCaseService;
    @NonNull
    private final ServiceCategoryModelResponseMapper serviceCategoryModelResponseMapper;

    @Override
    public ValueResponse<ServiceCategoryResponse> findById(Long serviceCategoryId) {
        ServiceCategory serviceCategory = serviceCategoryUseCaseService.findById(serviceCategoryId);
        return new ValueResponse<ServiceCategoryResponse>(serviceCategoryModelResponseMapper.toModel(serviceCategory));
    }
}
