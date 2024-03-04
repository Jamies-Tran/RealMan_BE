package com.capstone.realmen.dto.combo;

import java.util.Objects;

import lombok.Builder;

@Builder
public record ComboSearchCriteria(
        String search,
        Long branchId,
        Long priceFrom,
        Long priceTo) {

    public Boolean hasSearchEmpty() {
        return Objects.isNull(search) || search.isEmpty();
    }

    public Boolean hasBranchIdEmpty() {
        return Objects.isNull(branchId);
    }

    public Boolean hasPriceRangeEmpty() {
        return Objects.isNull(priceFrom) || Objects.isNull(priceTo);
    }

    public ComboSearchCriteria toLowerCase() {
        return ComboSearchCriteria.builder()
                .search(search.toLowerCase())
                .branchId(branchId)
                .priceFrom(priceFrom)
                .priceTo(priceTo)
                .build();
    }
}
