package com.capstone.realmen.controller.web.branch;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.realmen.controller.web.branch.models.BranchRequest;
import com.capstone.realmen.controller.web.branch.models.BranchServicePriceUpdateRequest;
import com.capstone.realmen.controller.web.branch.models.BranchServiceResponse;
import com.capstone.realmen.util.response.ValueResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "WEB - Branch")
@RequestMapping("/web/branches")
public interface BranchesAPI {
    @PostMapping
    @PreAuthorize("hasRole('ROLE_SHOPOWNER')")
    void save(@RequestBody @Valid BranchRequest branchRequest);

    @DeleteMapping("/branch-services/{branchServiceId}")
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER','ROLE_BRANCHMANAGER'})")
    void deleteBranchService(@PathVariable Long branchServiceId);

    @PatchMapping("/branch-services")
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER', 'ROLE_BRANCHMANAGER'})")
    void updateBranchServicePrice(
            @RequestParam(value = "branchServiceId") Long branchServiceId,
            @RequestBody @Valid BranchServicePriceUpdateRequest branchServicePriceUpdateRequest);

    @GetMapping("/branch-services/{branchServiceId}")
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER','ROLE_BRANCHMANAGER','ROLE_RECEPTIONIST'})")
    ValueResponse<BranchServiceResponse> findBranchServiceById(Long branchServiceId);
}
