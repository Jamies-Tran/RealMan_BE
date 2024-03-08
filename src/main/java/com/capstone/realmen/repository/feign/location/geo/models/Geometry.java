package com.capstone.realmen.repository.feign.location.geo.models;

import lombok.Builder;

@Builder
public record Geometry(
    Location location
) {
    
}
