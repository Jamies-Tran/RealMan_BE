package com.capstone.realmen.controller.list.location.autocomplete;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.realmen.util.response.ListResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "COLLECTION - Autocomplete")
@RequestMapping("/collection/autocomplete")
public interface AutoCompleteAPI {
    @GetMapping
    ListResponse<String> predictAddress(@RequestParam String input);
    
}
