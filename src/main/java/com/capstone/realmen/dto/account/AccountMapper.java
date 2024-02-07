package com.capstone.realmen.dto.account;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.enums.ERole;
import com.capstone.realmen.repository.database.account.AccountEntity;
import com.capstone.realmen.util.mappers.DTOMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper extends DTOMapper<Account, AccountEntity> {
    @Mapping(source = "password", target = "password")
    Account updatePassword(Account dto, String password);

    void updateBeforeSave(@MappingTarget AccountEntity entity, String password, ERole role);
}
