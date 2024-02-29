package com.capstone.realmen.util.response;

import java.util.List;

import lombok.Builder;

@Builder
public record ListResponse<T>(List<T> values) {
    
}
