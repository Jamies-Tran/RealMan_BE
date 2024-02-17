package com.capstone.realmen.controller.web.account.models;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.account.Account;
import com.capstone.realmen.util.mappers.RequestModelMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountRequestModelMapper extends RequestModelMapper<AccountRequest, Account> {
    
    Account toDto(UpdateAccountRequest update);
}
