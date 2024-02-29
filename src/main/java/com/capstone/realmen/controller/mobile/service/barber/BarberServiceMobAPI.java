package com.capstone.realmen.controller.mobile.service.barber;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.capstone.realmen.controller.mobile.service.barber.models.BarberServiceMobResponse;
import com.capstone.realmen.util.response.ValueResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "MOB - Barber Service")
@RequestMapping("/mobile/barber-services/{barberServiceId}")
public interface BarberServiceMobAPI {
    @GetMapping
    @PreAuthorize("hasAnyRole({'ROLE_CUSTOMER','ROLE_STYLIST','ROLE_MASSEUR'})")
    ValueResponse<BarberServiceMobResponse> findById(@PathVariable Long barberServiceId);
}
