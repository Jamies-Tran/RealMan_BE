package com.capstone.realmen.controller.mobile.account.models;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.account.Account;
import com.capstone.realmen.util.mappers.ResponseModelMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMobResponseModelMapper extends ResponseModelMapper<AccountMobResponse, Account> {

}
