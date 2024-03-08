package com.capstone.realmen.repository.feign.location.geo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public record Address(
                @JsonProperty("address_components") List<AddressComponent> addressComponents,
                Geometry geometry) {
}
