package com.capstone.realmen.repository.feign.location.autocomplete;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.realmen.repository.feign.location.autocomplete.models.Predictions;

@FeignClient(name = "autocomplete", url = "${goong.place.autocomplete}")
@Import(FeignClientConfiguration.class)
public interface AutoCompletePlaceHolder {
    @GetMapping
    Predictions predictAddresses(
            @RequestParam(value = "api_key") String apiKey,
            @RequestParam(value = "input") String input);

}
