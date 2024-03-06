package com.capstone.realmen.repository.feign.location.autocomplete;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.capstone.realmen.repository.feign.location.autocomplete.models.Prediction;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutoCompleteService {
    @Value("${goong.api.key}")
    private String apiKey;
    @NonNull
    private final AutoCompletePlaceHolder autoCompletePlaceHolder;

    public List<String> predictAddresses(String input) {
        return autoCompletePlaceHolder
                .predictAddresses(apiKey, input)
                .addresses()
                .stream()
                .map(Prediction::address)
                .toList();
    }
}
