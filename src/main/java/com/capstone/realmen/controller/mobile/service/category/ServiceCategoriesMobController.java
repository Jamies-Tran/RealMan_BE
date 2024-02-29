package com.capstone.realmen.controller.mobile.service.category;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import com.capstone.realmen.controller.mobile.service.category.models.ServiceCategoryMobModelResponseMapper;
import com.capstone.realmen.controller.mobile.service.category.models.ServiceCategoryMobResponse;
import com.capstone.realmen.dto.service.category.ServiceCategorySearchCriteria;
import com.capstone.realmen.service.service.category.ServiceCategoryUseCaseService;
import com.capstone.realmen.util.response.ListResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ServiceCategoriesMobController implements ServiceCategoriesMobAPI {
    @NonNull
    private final ServiceCategoryUseCaseService serviceCategoryUseCaseService;
    @NonNull
    private final ServiceCategoryMobModelResponseMapper responseMapper;

    @Override
    public ListResponse<ServiceCategoryMobResponse> findAll(String search) {
        ServiceCategorySearchCriteria searchCriteria = ServiceCategorySearchCriteria.builder()
                .search(search)
                .build();
        List<ServiceCategoryMobResponse> responses = serviceCategoryUseCaseService.findAll(searchCriteria)
                .stream().map(responseMapper::toModel).toList();
        return new ListResponse<>(responses);
    }

}
