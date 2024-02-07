package com.capstone.realmen.util.response;

import java.util.List;

import lombok.Builder;

@Builder
public record PageResponse<T>(
        List<T> content,
        Long totalElement,
        Integer totalPage,
        Integer currentPage,
        Integer pageSize) {
}
