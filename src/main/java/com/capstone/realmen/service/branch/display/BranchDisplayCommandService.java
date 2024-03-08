package com.capstone.realmen.service.branch.display;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capstone.realmen.dto.auditable.Auditable;
import com.capstone.realmen.dto.branch.display.BranchDisplay;
import com.capstone.realmen.dto.branch.display.BranchDisplayMapper;
import com.capstone.realmen.repository.database.branch.display.BranchDisplayEntity;
import com.capstone.realmen.repository.database.branch.display.BranchDisplayRepository;
import com.capstone.realmen.util.RequestContext;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BranchDisplayCommandService {
    @NonNull
    private final BranchDisplayRepository branchDisplayRepository;
    @NonNull
    private final BranchDisplayMapper branchDisplayMapper;
    @NonNull
    private final RequestContext requestContext;

    public void saveAll(Long branchId, List<BranchDisplay> branchDisplays) {
        List<BranchDisplayEntity> saveBranchDisplays = branchDisplays.stream()
                .map(bd -> branchDisplayMapper.create(bd, branchId,
                        Auditable.of(requestContext.getAccountId().toString())))
                .toList();
        branchDisplayRepository.saveAll(saveBranchDisplays);
    }
}
