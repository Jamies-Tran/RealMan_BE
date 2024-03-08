package com.capstone.realmen.repository.feign.location.geo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Location(
        @JsonProperty("lat") Double latitude,
        @JsonProperty("lng") Double longitude) {
}
