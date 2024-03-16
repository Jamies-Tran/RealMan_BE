package com.capstone.realmen.service.branch;

import org.springframework.stereotype.Service;

import com.capstone.realmen.dto.branch.service.BranchService;
import com.capstone.realmen.repository.database.branch.BranchRepository;
import com.capstone.realmen.service.branch.service.BranchServiceQueryService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BranchQueryService {
    @NonNull
    private final BranchRepository branchRepository;
    @NonNull
    private final BranchServiceQueryService branchServiceQueryService;

    public BranchService findBranchServiceById(Long branchServiceId) {
        return branchServiceQueryService.findById(branchServiceId);
    }
}
