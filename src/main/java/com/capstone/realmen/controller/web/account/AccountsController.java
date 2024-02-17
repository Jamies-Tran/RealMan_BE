package com.capstone.realmen.controller.web.account;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.realmen.controller.web.account.models.AccountRequest;
import com.capstone.realmen.controller.web.account.models.AccountRequestModelMapper;
import com.capstone.realmen.controller.web.account.models.AccountResponse;
import com.capstone.realmen.controller.web.account.models.AccountResponseModelMapper;
import com.capstone.realmen.controller.web.account.models.ChangePasswordRequest;
import com.capstone.realmen.controller.web.account.models.UpdateAccountRequest;
import com.capstone.realmen.dto.account.Account;
import com.capstone.realmen.dto.account.AccountSearchCriteria;
import com.capstone.realmen.dto.enums.EAccountStatus;
import com.capstone.realmen.dto.enums.ERole;
import com.capstone.realmen.service.account.AccountUseCaseService;
import com.capstone.realmen.util.request.CustomeSorter;
import com.capstone.realmen.util.request.PageRequestCustom;
import com.capstone.realmen.util.response.PageResponse;
import com.capstone.realmen.util.response.ValueResponse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AccountsController implements AccountsAPI {
    @NonNull
    private final AccountUseCaseService accountUseCaseService;
    @NonNull
    private final AccountRequestModelMapper accountRequestModelMapper;
    @NonNull
    private final AccountResponseModelMapper accountResponseModelMapper;

    @Override
    public void save(@Valid AccountRequest accountRequest) {
        Account account = accountRequestModelMapper.toDto(accountRequest);
        accountUseCaseService.saveWeb(account);
    }

    @Override
    public ValueResponse<AccountResponse> me() {
        Account account = accountUseCaseService.me();
        return new ValueResponse<AccountResponse>(accountResponseModelMapper.toModel(account));
    }

    @Override
    public PageResponse<AccountResponse> pageAll(String search, Long branchId, EAccountStatus status, List<ERole> roles,
            String sorter,
            @Min(1) Integer current, Integer pageSize) {
        CustomeSorter customerSorter = CustomeSorter.of(sorter);
        PageRequestCustom pageRequestCustom = PageRequestCustom.of(current, pageSize, customerSorter.sortBy());
        AccountSearchCriteria searchCriteria = AccountSearchCriteria.builder()
                .search(search)
                .branchId(branchId)
                .status(status)
                .roles(roles)
                .build();
        Page<AccountResponse> accounts = accountUseCaseService.pageAll(searchCriteria, pageRequestCustom)
                .map(accountResponseModelMapper::toModel);
        return new PageResponse<AccountResponse>(
                accounts.getContent(),
                accounts.getTotalElements(),
                accounts.getTotalPages(),
                pageRequestCustom.current(),
                accounts.getPageable().getPageSize());
    }

    @Override
    public void createOTPChangePassword(String phone) {
        accountUseCaseService.createOTPChangePassword(phone);
    }

    @Override
    public void changePassword(@Valid ChangePasswordRequest changePasswordRequest) {
        accountUseCaseService.changePassword(changePasswordRequest);
    }

    @Override
    public void updateMe(UpdateAccountRequest updateAccountRequest) {
        accountUseCaseService.updateMe(accountRequestModelMapper.toDto(updateAccountRequest));
    }
}
