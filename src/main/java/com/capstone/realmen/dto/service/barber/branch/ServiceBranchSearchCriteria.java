package com.capstone.realmen.dto.service.barber.branch;

import java.util.Objects;

import lombok.Builder;

@Builder
public record ServiceBranchSearchCriteria(
    String search,
    Long priceFrom,
    Long priceTo
) {
    public ServiceBranchSearchCriteria toLowerCase() {
        return ServiceBranchSearchCriteria.builder()
            .search(search.toLowerCase())
            .priceFrom(priceFrom)
            .priceTo(priceTo)
            .build();
    }

    public Boolean hasSearchEmpty() {
        return Objects.isNull(search) || search.isEmpty();
    }

    public Boolean hasPriceRangeEmpty() {
        return Objects.isNull(priceFrom) || Objects.isNull(priceTo);
    }
}
