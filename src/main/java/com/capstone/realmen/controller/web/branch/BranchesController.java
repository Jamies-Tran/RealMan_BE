package com.capstone.realmen.controller.web.branch;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.web.branch.models.BranchModelRequestMapper;
import com.capstone.realmen.controller.web.branch.models.BranchRequest;
import com.capstone.realmen.dto.branch.Branch;
import com.capstone.realmen.service.branch.BranchUseCaseService;

import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BranchesController implements BranchesAPI {
    @NonNull
    private final BranchUseCaseService branchUseCaseService;
    @NonNull
    private final BranchModelRequestMapper branchModelRequestMapper;

    @Override
    public void save(@Valid BranchRequest branchRequest) {
        Branch branch = branchModelRequestMapper.toDto(branchRequest);
        branchUseCaseService.save(branch);
    }
}
