package com.capstone.realmen.dto.branch;

import lombok.Builder;

@Builder
public record BranchSortCriteria(
        String sorter,
        Double latitude,
        Double longitude) {
}
