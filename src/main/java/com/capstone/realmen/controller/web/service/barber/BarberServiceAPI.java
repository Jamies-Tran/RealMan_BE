package com.capstone.realmen.controller.web.service.barber;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.capstone.realmen.controller.web.service.barber.models.BarberServiceRequest;
import com.capstone.realmen.controller.web.service.barber.models.BarberServiceResponse;
import com.capstone.realmen.controller.web.service.barber.models.branch.ServiceBranchResponse;
import com.capstone.realmen.util.response.PageResponse;
import com.capstone.realmen.util.response.ValueResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@Tag(name = "WEB - Barber Service")
@RequestMapping("/web/barber-services/{barberServiceId}")
public interface BarberServiceAPI {
    @GetMapping
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER','ROLE_BRANCHMANAGER','ROLE_RECEPTIONIST'})")
    ValueResponse<BarberServiceResponse> findById(@PathVariable Long barberServiceId);

    @GetMapping("/branches")
    PageResponse<ServiceBranchResponse> pageServiceBranch(
            @PathVariable Long barberServiceId,
            @RequestParam(required = false, name = "search", defaultValue = "") String search,
            @RequestParam(required = false, name = "priceFrom", defaultValue = "") Long priceFrom,
            @RequestParam(required = false, name = "priceTo", defaultValue = "") Long priceTo,
            @RequestParam(required = false, name = "sorter", defaultValue = "branchName_asc") String sorter,
            @RequestParam(required = false, name = "current", defaultValue = "1") @Min(1) Integer current,
            @RequestParam(required = false, name = "pageSize", defaultValue = "20") Integer pageSize);

    @PutMapping
    @PreAuthorize("hasRole('ROLE_SHOPOWNER')")
    void update(@PathVariable Long barberServiceId, @RequestBody @Valid BarberServiceRequest barberServiceRequest);

    @DeleteMapping
    @PreAuthorize("hasRole('ROLE_SHOPOWNER')")
    void delete(@PathVariable Long barberServiceId);
}
