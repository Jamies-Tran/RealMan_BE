package com.capstone.realmen.controller.web.service.category.models;

import lombok.Builder;

@Builder
public record ServiceCategoryResponse(
    Long serviceCategoryId,
    String serviceCategoryCode,
    String serviceCategoryName
) {
}
