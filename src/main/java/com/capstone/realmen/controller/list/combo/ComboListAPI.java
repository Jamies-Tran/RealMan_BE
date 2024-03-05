package com.capstone.realmen.controller.list.combo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.realmen.controller.list.combo.models.ComboListResponse;
import com.capstone.realmen.util.response.ListResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;

@Tag(name = "COLLECTION - Combo")
@RequestMapping("/collection/combos")
public interface ComboListAPI {
    @GetMapping
    ListResponse<ComboListResponse> findAll(
        @RequestParam(required = false, value = "search", defaultValue = "") String search,
        @RequestParam(required = false, value = "branchId", defaultValue = "") Long branchId,
        @RequestParam(required = false, value = "sorter", defaultValue = "comboName_asc") String sorter,
        @RequestParam(required = false, value = "current", defaultValue = "1") @Min(1) Integer currnet,
        @RequestParam(required = false, value = "pageSize", defaultValue = "10") Integer pageSize
    );
}
