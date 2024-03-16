package com.capstone.realmen.service.branch.service;

import org.springframework.stereotype.Service;

import com.capstone.realmen.controller.error.exceptions.ResourceNotFoundException;
import com.capstone.realmen.dto.branch.service.BranchService;
import com.capstone.realmen.info.branch.service.BranchServiceInfo;
import com.capstone.realmen.info.branch.service.BranchServiceInfoMapper;
import com.capstone.realmen.repository.database.branch.service.BranchServiceRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BranchServiceQueryService {
    @NonNull
    private final BranchServiceRepository branchServiceRepository;
    @NonNull
    private final BranchServiceInfoMapper infoMapper;

    public BranchService findById(Long branchServiceId) {
        BranchServiceInfo foundBranchService = branchServiceRepository.findInfoById(branchServiceId)
            .orElseThrow(ResourceNotFoundException::new);
        return infoMapper.toDto(foundBranchService);
    }
}
