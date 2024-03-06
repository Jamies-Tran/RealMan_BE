package com.capstone.realmen.repository.feign.location.autocomplete.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public record Predictions(@JsonProperty("predictions") List<Prediction> addresses) {

}
