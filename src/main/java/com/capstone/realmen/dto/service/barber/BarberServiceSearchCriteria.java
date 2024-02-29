package com.capstone.realmen.dto.service.barber;

import java.util.Objects;

import lombok.Builder;

@Builder
public record BarberServiceSearchCriteria(String search, Long branchId, Long priceFrom, Long priceTo) {

    public BarberServiceSearchCriteria toLowerCase() {
        return BarberServiceSearchCriteria.builder()
                .search(search.toLowerCase())
                .branchId(branchId)
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
