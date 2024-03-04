package com.capstone.realmen.controller.mobile.combo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.realmen.controller.mobile.combo.models.ComboMobResponse;
import com.capstone.realmen.util.response.PageResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;

@Tag(name = "MOB - Combo")
@RequestMapping("/mob/combos")
public interface CombosMobAPI {
    @GetMapping
    PageResponse<ComboMobResponse> pageAll(
        @RequestParam(required = false, value = "search", defaultValue = "") String search,
        @RequestParam(required = false, value = "branchId", defaultValue = "") Long branchId,
        @RequestParam(required = false, value = "priceFrom", defaultValue = "") Long priceFrom,
        @RequestParam(required = false, value = "priceTo", defaultValue = "") Long priceTo,
        @RequestParam(required = false, value = "sorter", defaultValue = "updatedAt_desc") String sorter,
        @RequestParam(required = false, value = "current", defaultValue = "1") @Min(1) Integer current,
        @RequestParam(required = false, value = "pageSize", defaultValue = "20") Integer pageSize
    );
}
