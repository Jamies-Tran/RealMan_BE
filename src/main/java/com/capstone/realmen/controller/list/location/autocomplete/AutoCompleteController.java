package com.capstone.realmen.controller.list.location.autocomplete;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.repository.feign.location.autocomplete.AutoCompleteService;
import com.capstone.realmen.util.response.ListResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AutoCompleteController implements AutoCompleteAPI {
    @NonNull
    private final AutoCompleteService autoCompleteService;

    @Override
    public ListResponse<String> predictAddress(String input) {
        List<String> address = autoCompleteService.predictAddresses(input);
        return new ListResponse<>(address);
    }
}
