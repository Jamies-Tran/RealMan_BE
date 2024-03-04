package com.capstone.realmen.controller.list.service.barber;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.capstone.realmen.controller.list.service.barber.models.BarberServiceListResponse;
import com.capstone.realmen.util.response.ListResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;

@Tag(name = "COLLECTION - Barber Service")
@RequestMapping("/collection/barber-service")
public interface BarberServiceListAPI {
    @GetMapping
    ListResponse<BarberServiceListResponse> getBarberServiceList(
            @RequestParam(required = false, value = "search", defaultValue = "") String search,
            @RequestParam(required = false, value = "branchId", defaultValue = "") Long branchId,
            @RequestParam(required = false, value = "sorter", defaultValue = "barberServiceName_asc") String sorter,
            @RequestParam(required = false, value = "current", defaultValue = "1") @Min(1) Integer current,
            @RequestParam(required = false, value = "pageSize", defaultValue = "10") Integer pageSize);
}
