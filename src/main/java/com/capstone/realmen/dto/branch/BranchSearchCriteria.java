package com.capstone.realmen.dto.branch;

import java.util.Objects;

import lombok.Builder;

@Builder
public record BranchSearchCriteria(
        String search,
        BranchSortCriteria sortCriteria) {
    public BranchSearchCriteria toLowerCase() {
        return BranchSearchCriteria.builder()
                .search(search.toLowerCase())
                .sortCriteria(sortCriteria)
                .build();
    }

    public Boolean hasSearchEmpty() {
        return Objects.nonNull(search) || search.isEmpty();
    }
}
