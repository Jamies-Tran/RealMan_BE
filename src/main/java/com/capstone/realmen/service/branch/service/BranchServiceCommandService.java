package com.capstone.realmen.service.branch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capstone.realmen.controller.error.exceptions.ResourceNotFoundException;
import com.capstone.realmen.dto.branch.service.BranchService;
import com.capstone.realmen.repository.database.branch.service.BranchServiceEntity;
import com.capstone.realmen.repository.database.branch.service.BranchServiceRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BranchServiceCommandService {
    @NonNull
    private final BranchServiceRepository branchServiceRepository;

    public void saveAll(Long branchId, List<BranchService> branchServices) {
        List<BranchServiceEntity> saveBranchServices = branchServices.stream()
                .map(bs -> BranchServiceEntity.builder()
                        .barberServiceId(bs.barberServiceId())
                        .branchServicePrice(bs.branchServicePrice())
                        .branchId(branchId)
                        .build())
                .toList();
        branchServiceRepository.saveAll(saveBranchServices);
    }
    

    public void updatePrice(Long branchServiceId, Long branchServicePrice) {
        BranchServiceEntity foundBranchService = branchServiceRepository
                .findById(branchServiceId)
                .orElseThrow(ResourceNotFoundException::new);
        foundBranchService.setBranchServicePrice(branchServicePrice);
        branchServiceRepository.save(foundBranchService);
    }

    public void delete(Long branchServiceId) {
        BranchServiceEntity foundBranchService = branchServiceRepository
                .findById(branchServiceId)
                .orElseThrow(ResourceNotFoundException::new);
        branchServiceRepository.delete(foundBranchService);
    }
}
