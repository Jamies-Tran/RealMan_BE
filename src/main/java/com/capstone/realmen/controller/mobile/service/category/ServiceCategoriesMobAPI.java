package com.capstone.realmen.controller.mobile.service.category;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.realmen.controller.mobile.service.category.models.ServiceCategoryMobResponse;
import com.capstone.realmen.util.response.ListResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "MOB - Service Category")
@RequestMapping("/mobile/service-categories")
public interface ServiceCategoriesMobAPI {
    @GetMapping
    @PreAuthorize("hasAnyRole({'ROLE_CUSTOMER','ROLE_STYLIST','ROLE_MASSEUR'})")
    ListResponse<ServiceCategoryMobResponse> findAll(
            @RequestParam(required = false, value = "search", defaultValue = "") String search);
}
