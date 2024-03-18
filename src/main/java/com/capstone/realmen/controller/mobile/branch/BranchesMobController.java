package com.capstone.realmen.controller.mobile.branch;

import org.springframework.web.bind.annotation.RestController;
import com.capstone.realmen.controller.mobile.branch.models.BranchMobModelResponseMapper;
import com.capstone.realmen.controller.mobile.branch.models.BranchMobResponse;
import com.capstone.realmen.dto.branch.BranchSearchCriteria;
import com.capstone.realmen.dto.branch.BranchSortCriteria;
import com.capstone.realmen.service.branch.BranchUseCaseService;
import com.capstone.realmen.util.request.PageRequestCustom;
import com.capstone.realmen.util.response.PageResponse;
import jakarta.validation.constraints.Min;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BranchesMobController implements BranchesMobAPI {
    @NonNull
    private final BranchUseCaseService branchUseCaseService;
    @NonNull
    private final BranchMobModelResponseMapper responseMapper;

    @Override
    public PageResponse<BranchMobResponse> pageBranches(String search, Double latitude,
            Double longitude, String sorter, @Min(1) Integer current, Integer pageSize) {
        BranchSortCriteria sortCriteria = BranchSortCriteria.builder()
            .sorter(sorter)
            .latitude(latitude)
            .longitude(longitude)
            .build();
        BranchSearchCriteria searchCriteria = BranchSearchCriteria.builder()
                .search(search)
                .sortCriteria(sortCriteria)
                .build();
        PageRequestCustom pageRequestCustom = PageRequestCustom.of(current, pageSize);
        return branchUseCaseService.pageBranch(searchCriteria, pageRequestCustom);
                

    }

}
