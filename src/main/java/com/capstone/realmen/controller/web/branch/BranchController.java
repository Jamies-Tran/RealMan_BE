package com.capstone.realmen.controller.web.branch;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.capstone.realmen.controller.web.branch.models.BranchServiceModelRequestMapper;
import com.capstone.realmen.controller.web.branch.models.BranchServiceRequestList;
import com.capstone.realmen.dto.branch.service.BranchService;
import com.capstone.realmen.service.branch.BranchUseCaseService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BranchController implements BranchAPI {
    @NonNull
    private final BranchUseCaseService branchUseCaseService;
    @NonNull
    private final BranchServiceModelRequestMapper requestMapper;

    @Override
    public void addBranchService(Long branchId, BranchServiceRequestList requests) {
        List<BranchService> branchServices = requests.requests().stream()
                .map(requestMapper::toDto).toList();
        branchUseCaseService.addBarberService(branchId, branchServices);
    }

}
