package com.capstone.realmen.controller.mobile.service.category;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.realmen.controller.mobile.service.category.models.ServiceCategoryMobResponse;
import com.capstone.realmen.util.response.ValueResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "MOB - Service Category")
@RequestMapping("/mobile/service-categories/{serviceCategoryId}")
public interface ServiceCategoryMobAPI {
    @GetMapping
    @PreAuthorize("hasAnyRole({'ROLE_CUSTOMER','ROLE_STYLIST','ROLE_MASSEUR'})")
    ValueResponse<ServiceCategoryMobResponse> findById(@PathVariable Long serviceCategoryId);
}
