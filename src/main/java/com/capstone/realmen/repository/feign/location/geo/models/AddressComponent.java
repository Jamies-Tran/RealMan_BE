package com.capstone.realmen.repository.feign.location.geo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public record AddressComponent(
        @JsonProperty("long_name") String addressComponent) {
}
