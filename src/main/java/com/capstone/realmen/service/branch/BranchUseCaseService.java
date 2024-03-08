package com.capstone.realmen.service.branch;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.realmen.dto.branch.Branch;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BranchUseCaseService {
    @NonNull
    private final BranchCommandService branchCommandService;

    @Transactional
    public void save(Branch branch) {
        branchCommandService.save(branch);
    }
}
