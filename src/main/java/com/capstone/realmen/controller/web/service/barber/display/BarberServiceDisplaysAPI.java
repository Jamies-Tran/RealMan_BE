package com.capstone.realmen.controller.web.service.barber.display;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "WEB - Barber Service Display")
@RequestMapping("/web/barber-service-display")
public interface BarberServiceDisplaysAPI {
    @DeleteMapping
    @PreAuthorize("hasRole('ROLE_SHOPOWNER')")
    void deleteAll(
            @RequestParam(required = false, value = "barberServiceIds") List<Long> barberServiceIds);
}
