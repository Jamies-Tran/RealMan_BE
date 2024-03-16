package com.capstone.realmen.controller.web.branch;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.capstone.realmen.controller.web.branch.models.BranchServiceRequestList;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "WEB - Branch")
@RequestMapping("/web/branches/{branchId}")
public interface BranchAPI {
    @PostMapping("/branch-services")
    @PreAuthorize("hasAnyRole({'ROLE_SHOPOWNER','ROLE_BRANCHMANAGER'})")
    void addBranchService(@PathVariable Long branchId,@RequestBody BranchServiceRequestList requests);
}
