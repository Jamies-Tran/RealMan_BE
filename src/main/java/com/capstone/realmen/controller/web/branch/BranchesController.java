package com.capstone.realmen.controller.web.branch;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.web.branch.models.BarberServiceModelResposneV2Mapper;
import com.capstone.realmen.controller.web.branch.models.BarberServiceResponseV2;
import com.capstone.realmen.controller.web.branch.models.BranchModelRequestMapper;
import com.capstone.realmen.controller.web.branch.models.BranchModelResponseV2Mapper;
import com.capstone.realmen.controller.web.branch.models.BranchRequest;
import com.capstone.realmen.controller.web.branch.models.BranchResponseV2;
import com.capstone.realmen.controller.web.branch.models.BranchServicePriceUpdateRequest;
import com.capstone.realmen.controller.web.branch.models.BranchServiceResponse;
import com.capstone.realmen.dto.branch.Branch;
import com.capstone.realmen.dto.branch.service.BranchService;
import com.capstone.realmen.service.branch.BranchUseCaseService;
import com.capstone.realmen.util.response.ValueResponse;

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
    @NonNull
    private final BranchModelResponseV2Mapper branchResponseV2Mapper;
    @NonNull
    private final BarberServiceModelResposneV2Mapper barberServiceResponseV2Mapper;

    @Override
    public void save(@Valid BranchRequest branchRequest) {
        Branch branch = branchModelRequestMapper.toDto(branchRequest);
        branchUseCaseService.save(branch);
    }

    @Override
    public void updateBranchServicePrice(Long branchServiceId,
            @Valid BranchServicePriceUpdateRequest branchServicePriceUpdateRequest) {
        branchUseCaseService.updateBranchServicePrice(branchServiceId,
                branchServicePriceUpdateRequest.branchServicePrice());
    }

    @Override
    public void deleteBranchService(Long branchServiceId) {
        branchUseCaseService.deleteBranchService(branchServiceId);
    }

    @Override
    public ValueResponse<BranchServiceResponse> findBranchServiceById(Long branchServiceId) {
        BranchService foundBranchService = branchUseCaseService.findBranchServiceById(branchServiceId);
        BranchResponseV2 branch = branchResponseV2Mapper.toModel(foundBranchService);
        BarberServiceResponseV2 barberService = barberServiceResponseV2Mapper.toModel(foundBranchService);

        return new ValueResponse<>(BranchServiceResponse.builder()
                .branchServiceId(foundBranchService.branchServiceId())
                .branch(branch)
                .barberService(barberService).build());
    }
}
