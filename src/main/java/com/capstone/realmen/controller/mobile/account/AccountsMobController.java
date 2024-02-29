package com.capstone.realmen.controller.mobile.account;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.mobile.account.models.AccountMobRequestModelMapper;
import com.capstone.realmen.controller.mobile.account.models.AccountMobResponse;
import com.capstone.realmen.controller.mobile.account.models.AccountMobResponseModelMapper;
import com.capstone.realmen.controller.mobile.account.models.UpdateAccountMobRequest;
import com.capstone.realmen.controller.mobile.account.models.AccountMobRequest;
import com.capstone.realmen.dto.account.Account;
import com.capstone.realmen.dto.account.AccountSearchCriteria;
import com.capstone.realmen.dto.enums.EAccountStatus;
import com.capstone.realmen.dto.enums.ERole;
import com.capstone.realmen.service.account.AccountUseCaseService;
import com.capstone.realmen.util.request.SortCustom;
import com.capstone.realmen.util.request.PageRequestCustom;
import com.capstone.realmen.util.response.PageResponse;
import com.capstone.realmen.util.response.ValueResponse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AccountsMobController implements AccountsMobAPI {
    @NonNull
    private final AccountUseCaseService accountUseCaseService;
    @NonNull
    private final AccountMobRequestModelMapper accountMobRequestModelMapper;
    @NonNull
    private final AccountMobResponseModelMapper accountMobResponseModelMapper;

    @Override
    public void save(@Valid AccountMobRequest accountRequest) {
        Account account = accountMobRequestModelMapper.toDto(accountRequest);
        accountUseCaseService.save(account);
    }

    @Override
    public PageResponse<AccountMobResponse> pageAll(String search, Long branchId, String sorter, @Min(1) Integer current,
            Integer pageSize) {
        PageRequestCustom pageRequestCustom = PageRequestCustom.of(current, pageSize, SortCustom.of(sorter));
        AccountSearchCriteria searchCriteria = AccountSearchCriteria.builder()
                .search(search)
                .branchId(branchId)
                .roles(List.of(ERole.STYLIST, ERole.MASSEUR))
                .status(EAccountStatus.ACTIVATED)
                .build();
        Page<AccountMobResponse> accounts = accountUseCaseService.pageAll(searchCriteria, pageRequestCustom)
                .map(accountMobResponseModelMapper::toModel);
        return new PageResponse<>(accounts.getContent(), accounts.getTotalElements(), accounts.getTotalPages(),
                pageRequestCustom.current(), accounts.getPageable().getPageSize());
    }

    @Override
    public ValueResponse<AccountMobResponse> me() {
        Account account = accountUseCaseService.me();
        return new ValueResponse<AccountMobResponse>(accountMobResponseModelMapper.toModel(account));
    }

    @Override
    public void updateMe(UpdateAccountMobRequest updateAccountRequest) {
        accountUseCaseService.updateMe(accountMobRequestModelMapper.toDto(updateAccountRequest));
    }

}
