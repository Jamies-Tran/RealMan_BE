package com.capstone.realmen.service.branch;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.realmen.controller.mobile.branch.models.BranchMobResponse;
import com.capstone.realmen.dto.branch.Branch;
import com.capstone.realmen.dto.branch.BranchSearchCriteria;
import com.capstone.realmen.dto.branch.service.BranchService;
import com.capstone.realmen.util.request.PageRequestCustom;
import com.capstone.realmen.util.response.PageResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BranchUseCaseService {
    @NonNull
    private final BranchCommandService commandService;
    @NonNull
    private final BranchQueryService queryService;

    @Transactional
    public void save(Branch branch) {
        commandService.save(branch);
    }

    @Transactional
    public void addBarberService(Long branchId, List<BranchService> branchServices) {
        commandService.addBarberService(branchId, branchServices);
    }

    @Transactional
    public void updateBranchServicePrice(Long branchServiceId, Long branchServicePrice) {
        commandService.updateBranchServicePrice(branchServiceId, branchServicePrice);
    }

    @Transactional
    public void deleteBranchService(Long branchServiceId) {
        commandService.deleteBranchService(branchServiceId);
    }

    public BranchService findBranchServiceById(Long branchServiceId) {
        return queryService.findBranchServiceById(branchServiceId);
    }

    public PageResponse<BranchMobResponse> pageBranch(BranchSearchCriteria searchCriteria, PageRequestCustom pageRequestCustom) {
        return queryService.pageBranches(searchCriteria, pageRequestCustom);
    }
}
