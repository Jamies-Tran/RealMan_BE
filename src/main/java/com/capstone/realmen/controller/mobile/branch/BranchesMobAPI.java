package com.capstone.realmen.controller.mobile.branch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.capstone.realmen.controller.mobile.branch.models.BranchMobResponse;
import com.capstone.realmen.util.response.PageResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;

@Tag(name = "MOB - Branch")
@RequestMapping("/mobile/branches")
public interface BranchesMobAPI {
    @GetMapping
    PageResponse<BranchMobResponse> pageBranches(
            @RequestParam(required = false, value = "search", defaultValue = "") String search,
            @RequestParam(required = false, value = "latitude", defaultValue = "0.0") Double latitude,
            @RequestParam(required = false, value = "longitude", defaultValue = "0.0") Double longitude,
            @RequestParam(required = false, value = "sorter", defaultValue = "updatedAt_desc") String sorter,
            @RequestParam(required = false, value = "current", defaultValue = "1") @Min(1) Integer current,
            @RequestParam(required = false, value = "pageSize", defaultValue = "20") Integer pageSize);
}
