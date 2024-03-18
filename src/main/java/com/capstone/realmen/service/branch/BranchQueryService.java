package com.capstone.realmen.service.branch;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.capstone.realmen.controller.mobile.branch.models.BranchMobModelResponseMapper;
import com.capstone.realmen.controller.mobile.branch.models.BranchMobResponse;
import com.capstone.realmen.dto.branch.Branch;
import com.capstone.realmen.dto.branch.BranchSearchCriteria;
import com.capstone.realmen.dto.branch.service.BranchService;
import com.capstone.realmen.info.branch.BranchInfoMapper;
import com.capstone.realmen.repository.database.branch.BranchRepository;
import com.capstone.realmen.service.branch.service.BranchServiceQueryService;
import com.capstone.realmen.util.request.PageRequestCustom;
import com.capstone.realmen.util.request.SortCustomV2;
import com.capstone.realmen.util.response.PageResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BranchQueryService {
    @NonNull
    private final BranchRepository branchRepository;
    @NonNull
    private final BranchServiceQueryService branchServiceQueryService;
    @NonNull
    private final BranchInfoMapper branchInfoMapper;
    @NonNull
    private final BranchMobModelResponseMapper responseMapper;

    public BranchService findBranchServiceById(Long branchServiceId) {
        return branchServiceQueryService.findById(branchServiceId);
    }

    public PageResponse<BranchMobResponse> pageBranches(BranchSearchCriteria searchCriteria,
            PageRequestCustom pageRequestCustom) {
        Page<Branch> pageBranches = branchRepository
                .pageBranches(searchCriteria.toLowerCase(), pageRequestCustom.pageRequest())
                .map(b -> branchInfoMapper.toDto(b, searchCriteria.sortCriteria()));
        String sorter = searchCriteria.sortCriteria().sorter();
        List<BranchMobResponse> contents = SortCustomV2.sortList(pageBranches.getContent(), sorter)
                .stream().map(responseMapper::toModel).toList();
        return new PageResponse<>(
                contents, pageBranches.getTotalElements(),
                pageBranches.getTotalPages(),
                pageRequestCustom.current(),
                pageRequestCustom.pageRequest().getPageSize());
    }
}
