package com.capstone.realmen.controller.web.service.category;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.web.service.category.models.ServiceCategoryModelResponseMapper;
import com.capstone.realmen.controller.web.service.category.models.ServiceCategoryResponse;
import com.capstone.realmen.dto.service.category.ServiceCategorySearchCriteria;
import com.capstone.realmen.service.service.category.ServiceCategoryUseCaseService;
import com.capstone.realmen.util.response.ListResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ServiceCategoriesController implements ServiceCategoriesAPI {
    @NonNull
    private final ServiceCategoryUseCaseService serviceCategoryUseCaseService;
    @NonNull
    private final ServiceCategoryModelResponseMapper serviceCategoryModelResponseMapper;

    @Override
    public ListResponse<ServiceCategoryResponse> findAll(String search) {
        ServiceCategorySearchCriteria searchCriteria = new ServiceCategorySearchCriteria(search);
        List<ServiceCategoryResponse> serviceCategories = serviceCategoryUseCaseService
                .findAll(searchCriteria)
                .stream()
                .map(serviceCategoryModelResponseMapper::toModel).toList();
        return new ListResponse<>(serviceCategories);
    }

}
