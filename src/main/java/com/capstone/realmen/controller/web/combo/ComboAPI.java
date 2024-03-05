package com.capstone.realmen.controller.web.combo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.capstone.realmen.controller.web.combo.models.ComboResponse;
import com.capstone.realmen.controller.web.combo.models.ComboUpdateRequest;
import com.capstone.realmen.util.response.ValueResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "WEB - Combo")
@RequestMapping("/web/combos/{comboId}")
public interface ComboAPI {
    @GetMapping
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER','ROLE_BRANCHMANAGER','ROLE_RECEPTIONIST'})")
    ValueResponse<ComboResponse> findById(@PathVariable Long comboId);

    @PutMapping
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER','ROLE_BRANCHMANAGER'})")
    void update(Long comboId,@RequestBody @Valid ComboUpdateRequest comboRequest);
}
