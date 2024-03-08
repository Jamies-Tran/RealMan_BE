package com.capstone.realmen.controller.web.branch;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capstone.realmen.controller.web.branch.models.BranchRequest;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "WEB - Branch")
@RequestMapping("/web/branches")
public interface BranchesAPI {
    @PostMapping
    @PreAuthorize("hasRole('ROLE_SHOPOWNER')")
    void save(@RequestBody @Valid BranchRequest branchRequest);
}
