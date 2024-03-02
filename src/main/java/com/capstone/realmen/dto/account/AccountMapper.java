package com.capstone.realmen.dto.account;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.auditable.Auditable;
import com.capstone.realmen.dto.enums.EAccountStatus;
import com.capstone.realmen.dto.enums.ERole;
import com.capstone.realmen.repository.database.account.AccountEntity;
import com.capstone.realmen.util.mappers.DTOMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper extends DTOMapper<Account, AccountEntity> {
    @Mapping(source = "password", target = "password")
    Account updatePassword(Account dto, String password);

    void updateBeforeSave(@MappingTarget AccountEntity entity, String password, ERole role);

    void changePassword(@MappingTarget AccountEntity entity, String password, Auditable auditable);

    @Mapping(target = "accountId", ignore = true)
    @Mapping(target = "branchId", ignore = true)
    @Mapping(target = "staffCode", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "accountStatus", ignore = true)
    @Mapping(target = "role", ignore = true)
    void update(@MappingTarget AccountEntity entity, Account dto, Auditable auditable);

    @Mapping(target = "accountStatus", source = "accountStatus")
    void updateStatus(@MappingTarget AccountEntity entity, EAccountStatus accountStatus, Auditable auditable);
}
