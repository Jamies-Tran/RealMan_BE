package com.capstone.realmen.repository.feign.location.autocomplete.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public record Prediction(
        @JsonProperty("description") String address) {
}
