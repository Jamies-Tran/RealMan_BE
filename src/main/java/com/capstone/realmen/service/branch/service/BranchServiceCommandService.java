package com.capstone.realmen.service.branch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capstone.realmen.repository.database.branch.service.BranchServiceEntity;
import com.capstone.realmen.repository.database.branch.service.BranchServiceRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BranchServiceCommandService {
    @NonNull
    private final BranchServiceRepository branchServiceRepository;

    public void saveAll(Long branchId, List<Long> barberServiceIds) {
        List<BranchServiceEntity> branchServices = barberServiceIds.stream()
                .map(bs -> BranchServiceEntity.builder()
                        .barberServiceId(bs)
                        .branchId(branchId)
                        .build())
                .toList();
        branchServiceRepository.saveAll(branchServices);
    }

}
