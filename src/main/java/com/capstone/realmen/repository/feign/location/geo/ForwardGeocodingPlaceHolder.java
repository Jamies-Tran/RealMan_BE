package com.capstone.realmen.repository.feign.location.geo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.realmen.repository.feign.location.geo.models.AddressResponse;

@FeignClient(name = "forwardGeocoding", url = "${goong.geometry}")
@Import(FeignClientConfiguration.class)
public interface ForwardGeocodingPlaceHolder {
    @GetMapping
    AddressResponse getAddressResponse(
        @RequestParam(value = "api_key") String apiKey, 
        @RequestParam(value = "address") String address);
}
