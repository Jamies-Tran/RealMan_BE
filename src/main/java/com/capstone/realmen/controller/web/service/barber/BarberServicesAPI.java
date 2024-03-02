package com.capstone.realmen.controller.web.service.barber;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.realmen.controller.web.service.barber.models.BarberServiceRequest;
import com.capstone.realmen.controller.web.service.barber.models.BarberServiceResponse;
import com.capstone.realmen.util.response.PageResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@Tag(name = "WEB - Barber Service")
@RequestMapping("/web/barber-services")
public interface BarberServicesAPI {
    @PostMapping
    @PreAuthorize("hasRole('ROLE_SHOPOWNER')")
    public void save(@RequestBody @Valid BarberServiceRequest barberServiceRequest);

    @GetMapping
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER', 'ROLE_BRANCHMANAGER', 'ROLE_RECEPTIONIST'})")
    public PageResponse<BarberServiceResponse> pageByServiceCategoryId(
            @RequestParam(required = true, value = "categoryId", defaultValue = "1") Long categoryId,
            @RequestParam(required = false, value = "search", defaultValue = "") String search,
            @RequestParam(required = false, value = "priceFrom", defaultValue = "") Long priceFrom,
            @RequestParam(required = false, value = "priceTo", defaultValue = "") Long priceTo,
            @RequestParam(required = false, value = "sorter", defaultValue = "updatedAt_desc") String sorter,
            @RequestParam(required = false, value = "current", defaultValue = "1") @Min(1) Integer current,
            @RequestParam(required = false, value = "pageSize", defaultValue = "20") Integer pageSize);
}
