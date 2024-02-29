package com.capstone.realmen.controller.web.service.category;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.capstone.realmen.controller.web.service.category.models.ServiceCategoryResponse;
import com.capstone.realmen.util.response.ValueResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "WEB - Service Category")
@RequestMapping("/web/service-categories/{serviceCategoryId}")
public interface ServiceCategoryAPI {
    @GetMapping
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER','ROLE_BRANCHMANAGER','ROLE_RECEPTIONIST'})")
    ValueResponse<ServiceCategoryResponse> findById(@PathVariable Long serviceCategoryId);
}
