package com.capstone.realmen.service.account;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.capstone.realmen.controller.error.exceptions.ResourceNotFoundException;
import com.capstone.realmen.dto.account.Account;
import com.capstone.realmen.dto.account.AccountMapper;
import com.capstone.realmen.dto.account.AccountSearchCriteria;
import com.capstone.realmen.repository.database.account.AccountEntity;
import com.capstone.realmen.repository.database.account.AccountRepository;
import com.capstone.realmen.util.RequestContext;
import com.capstone.realmen.util.request.PageRequestCustom;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountQueryService {
    @NonNull
    private final AccountRepository accountRepository;
    @NonNull
    private final AccountMapper accountMapper;
    @NonNull
    private final RequestContext requestContext;

    public Account findByPhoneOrStaffCode(String phoneOrStaffCode) {
        AccountEntity foundAccount = accountRepository.findByPhoneOrStaffCode(phoneOrStaffCode)
                .orElseThrow(ResourceNotFoundException::new);
        return accountMapper.toDto(foundAccount);
    }

    public Account findByPhone(String phone) {
        AccountEntity foundAccount = accountRepository.findByPhone(phone)
                .orElseThrow(ResourceNotFoundException::new);
        return accountMapper.toDto(foundAccount);
    }

    public Account findByStaffCode(String staffCode) {
        AccountEntity foundAccount = accountRepository.findByStaffCode(staffCode)
                .orElseThrow(ResourceNotFoundException::new);
        return accountMapper.toDto(foundAccount);
    }

    public Account findByAccountId(Long accountId) {
        AccountEntity foundAccount = accountRepository.findById(accountId).orElseThrow(ResourceNotFoundException::new);
        return accountMapper.toDto(foundAccount);
    }

    public Account me() {
        AccountEntity foundAccount = accountRepository.findById(requestContext.getAccountId())
                .orElseThrow(ResourceNotFoundException::new);
        return accountMapper.toDto(foundAccount);
    }

    public Page<Account> pageAll(AccountSearchCriteria searchCriteria, PageRequestCustom pageRequestCustom) {
        Page<Account> accounts = accountRepository
                .pageAll(searchCriteria.toLowerCase(), pageRequestCustom.pageRequest())
                .map(accountMapper::toDto);
        return accounts;
    }

}
