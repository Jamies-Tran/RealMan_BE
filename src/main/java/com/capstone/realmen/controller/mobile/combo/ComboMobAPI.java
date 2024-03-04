package com.capstone.realmen.controller.mobile.combo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.realmen.controller.mobile.combo.models.ComboMobResponse;
import com.capstone.realmen.util.response.ValueResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "MOB - Combo")
@RequestMapping("/mob/combos/{comboId}")
public interface ComboMobAPI {
    @GetMapping
    @PreAuthorize("hasAnyRole({'ROLE_CUSTOMER','ROLE_STYLIST','ROLE_MASSEUR'})")
    ValueResponse<ComboMobResponse> findById(@PathVariable Long comboId);
}
