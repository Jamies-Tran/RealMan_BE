package com.capstone.realmen.repository.feign.location.geo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.capstone.realmen.repository.feign.location.geo.models.AddressResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ForwardGeocodingService {
    @Value("${goong.api.key}")
    private String apiKey;
    @NonNull
    private final ForwardGeocodingPlaceHolder forwardGeocodingPlaceHolder;

    public AddressResponse getAddressComponents(String address) {
        return forwardGeocodingPlaceHolder.getAddressResponse(apiKey, address);
    }
}
