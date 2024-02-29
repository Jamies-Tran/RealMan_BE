package com.capstone.realmen.controller.web.service.barber;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.realmen.controller.web.service.barber.models.BarberServiceResponse;
import com.capstone.realmen.util.response.ValueResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "WEB - Barber Service")
@RequestMapping("/web/barber-services/{barberServiceId}")
public interface BarberServiceAPI {
    @GetMapping
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER','ROLE_BRANCHMANAGER','ROLE_RECEPTIONIST'})")
    ValueResponse<BarberServiceResponse> findById(@PathVariable Long barberServiceId);
}
