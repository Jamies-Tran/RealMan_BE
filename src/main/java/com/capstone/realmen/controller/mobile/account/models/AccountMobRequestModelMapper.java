package com.capstone.realmen.controller.mobile.account.models;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import com.capstone.realmen.dto.account.Account;
import com.capstone.realmen.util.mappers.RequestModelMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMobRequestModelMapper extends RequestModelMapper<AccountMobRequest, Account> {
    Account toDto(UpdateAccountMobRequest update);

    @Mapping(target = "role", expression = "java(com.capstone.realmen.dto.enums.ERole.CUSTOMER)")
    Account toCustomerAccount(AccountMobRequest model);
}
