package com.capstone.realmen.controller.web.combo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.realmen.controller.web.combo.models.ComboRequest;
import com.capstone.realmen.controller.web.combo.models.ComboResponse;
import com.capstone.realmen.util.response.PageResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@Tag(name = "WEB - Combo")
@RequestMapping("/web/combos")
public interface CombosAPI {
    @PostMapping
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER','ROLE_BRANCHMANAGER'})")
    void save(@RequestBody @Valid ComboRequest comboRequest);

    @GetMapping
    PageResponse<ComboResponse> pageAll(
        @RequestParam(required = false, value = "search", defaultValue = "") String search,
        @RequestParam(required = false, value = "branchId", defaultValue = "") Long branchId,
        @RequestParam(required = false, value = "priceFrom", defaultValue = "") Long priceFrom,
        @RequestParam(required = false, value = "priceTo", defaultValue = "") Long priceTo,
        @RequestParam(required = false, value = "sorter", defaultValue = "updatedAt_desc") String sorter,
        @RequestParam(required = false, value = "current", defaultValue = "1") @Min(1) Integer current,
        @RequestParam(required = false, value = "pageSize", defaultValue = "20") Integer pageSize
    );
}
