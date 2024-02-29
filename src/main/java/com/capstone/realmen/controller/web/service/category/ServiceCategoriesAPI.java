package com.capstone.realmen.controller.web.service.category;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.realmen.controller.web.service.category.models.ServiceCategoryResponse;
import com.capstone.realmen.util.response.ListResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "WEB - Service Category")
@RequestMapping("/web/service-categories")
public interface ServiceCategoriesAPI {
    @GetMapping
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER','ROLE_BRANCHMANAGER','ROLE_RECEPTIONIST'})")
    ListResponse<ServiceCategoryResponse> findAll(
            @RequestParam(required = false, value = "search", defaultValue = "") String search);
}
