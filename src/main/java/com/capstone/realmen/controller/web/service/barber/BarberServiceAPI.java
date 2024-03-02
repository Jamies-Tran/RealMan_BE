package com.capstone.realmen.controller.web.service.barber;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.realmen.controller.web.service.barber.models.BarberServiceRequest;
import com.capstone.realmen.controller.web.service.barber.models.BarberServiceResponse;
import com.capstone.realmen.util.response.ValueResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "WEB - Barber Service")
@RequestMapping("/web/barber-services/{barberServiceId}")
public interface BarberServiceAPI {
    @GetMapping
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER','ROLE_BRANCHMANAGER','ROLE_RECEPTIONIST'})")
    ValueResponse<BarberServiceResponse> findById(@PathVariable Long barberServiceId);

    @PutMapping
    @PreAuthorize("hasRole('ROLE_SHOPOWNER')")
    void update(@PathVariable Long barberServiceId, @RequestBody @Valid BarberServiceRequest barberServiceRequest);

    @DeleteMapping
    @PreAuthorize("hasRole('ROLE_SHOPOWNER')")
    void delete(@PathVariable Long barberServiceId);
}
