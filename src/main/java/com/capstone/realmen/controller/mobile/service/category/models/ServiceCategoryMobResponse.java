package com.capstone.realmen.controller.mobile.service.category.models;

import lombok.Builder;

@Builder
public record ServiceCategoryMobResponse(
    Long serviceCategoryId,
    String serviceCategoryCode,
    String serviceCategoryName
) {   
}
