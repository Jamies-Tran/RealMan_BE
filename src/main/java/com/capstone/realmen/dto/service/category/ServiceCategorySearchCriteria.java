package com.capstone.realmen.dto.service.category;

import java.util.Objects;

import lombok.Builder;

@Builder
public record ServiceCategorySearchCriteria(
    String search // code + name
) {
    public ServiceCategorySearchCriteria toLowerCase() {
        return ServiceCategorySearchCriteria.builder()
            .search(search.toLowerCase())
            .build();
    }

    public Boolean hasSearchEmpty() {
        return Objects.isNull(search) || search.isEmpty();
    }
}
