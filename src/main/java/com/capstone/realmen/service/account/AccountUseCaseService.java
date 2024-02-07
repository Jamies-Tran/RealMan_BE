package com.capstone.realmen.service.account;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.realmen.dto.account.Account;
import com.capstone.realmen.dto.account.AccountSearchCriteria;
import com.capstone.realmen.util.request.PageRequestCustom;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountUseCaseService {
    @NonNull
    private final AccountCommandService accountCommandService;
    @NonNull
    private final AccountQueryService accountQueryService;

    @Transactional
    public void saveWeb(Account account) {
        accountCommandService.saveWeb(account);
    }

    @Transactional
    public void save(Account account) {
        accountCommandService.save(account);
    }

    @Transactional
    public void createOTP(String phone) {
        accountCommandService.createOTP(phone);
    }

    @Transactional
    public void disablePassword(Long accountId) {
        accountCommandService.disablePassword(accountId);
    }

    public Account findByPhoneOrStaffCode(String phoneOrStaffCode) {
        return accountQueryService.findByPhoneOrStaffCode(phoneOrStaffCode);
    }

    public Account findByPhone(String phone) {
        return accountQueryService.findByPhone(phone);
    }

    public Account findByStaffCode(String staffCode) {
        return accountQueryService.findByStaffCode(staffCode);
    }

    public Account findByAccountId(Long accountId) {
        return accountQueryService.findByAccountId(accountId);
    }

    public Account me() {
        return accountQueryService.me();
    }

    public Page<Account> pageAll(AccountSearchCriteria searchCriteria, PageRequestCustom pageRequestCustom) {
        return accountQueryService.pageAll(searchCriteria, pageRequestCustom);
    }
}
