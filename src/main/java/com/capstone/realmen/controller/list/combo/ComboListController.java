package com.capstone.realmen.controller.list.combo;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.list.combo.models.ComboListModelResponseMapper;
import com.capstone.realmen.controller.list.combo.models.ComboListResponse;
import com.capstone.realmen.dto.combo.ComboSearchCriteria;
import com.capstone.realmen.service.combo.ComboUseCaseService;
import com.capstone.realmen.util.request.PageRequestCustom;
import com.capstone.realmen.util.request.SortCustom;
import com.capstone.realmen.util.response.ListResponse;

import jakarta.validation.constraints.Min;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ComboListController implements ComboListAPI {
    @NonNull
    private final ComboUseCaseService comboUseCaseService;
    @NonNull
    private final ComboListModelResponseMapper responseMapper;

    @Override
    public ListResponse<ComboListResponse> findAll(String search, Long branchId, String sorter, @Min(1) Integer currnet,
            Integer pageSize) {
        PageRequestCustom pageRequestCustom = PageRequestCustom.of(currnet, pageSize, SortCustom.of(sorter));
        ComboSearchCriteria searchCriteria = ComboSearchCriteria.builder()
                .search(search)
                .branchId(branchId)
                .build();
        List<ComboListResponse> responses = comboUseCaseService.getComboList(searchCriteria, pageRequestCustom)
                .stream().map(responseMapper::toModel).toList();
        return new ListResponse<>(responses);
    }
}
