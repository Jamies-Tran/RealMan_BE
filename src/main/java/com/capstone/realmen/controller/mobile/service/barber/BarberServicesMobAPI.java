package com.capstone.realmen.controller.mobile.service.barber;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.realmen.controller.mobile.service.barber.models.BarberServiceMobResponse;
import com.capstone.realmen.util.response.PageResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;

@Tag(name = "MOB - Barber Service")
@RequestMapping("/mobile/barber-services")
public interface BarberServicesMobAPI {

    @GetMapping
    @PreAuthorize("hasAnyRole({'ROLE_CUSTOMER','ROLE_STYLIST','ROLE_MASSEUR'})")
    PageResponse<BarberServiceMobResponse> pageAll(
            @RequestParam(required = false, value = "categoryId", defaultValue = "1") Long serviceCategoryId,
            @RequestParam(required = false, value = "branchId", defaultValue = "") Long branchId,
            @RequestParam(required = false, value = "search", defaultValue = "") String search,
            @RequestParam(required = false, value = "priceFrom", defaultValue = "") Long priceFrom,
            @RequestParam(required = false, value = "priceTo", defaultValue = "") Long priceTo,
            @RequestParam(required = false, value = "sorter", defaultValue = "updatedAt_desc") String sorter,
            @RequestParam(required = false, value = "current", defaultValue = "1") @Min(1) Integer current,
            @RequestParam(required = false, value = "pageSize", defaultValue = "20") Integer pageSize);
}
