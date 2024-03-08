package com.capstone.realmen.repository.feign.location.geo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public record AddressResponse(
        @JsonProperty("results") List<Address> address) {
}
