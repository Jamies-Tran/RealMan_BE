package com.capstone.realmen.dto.branch.display;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.auditable.Auditable;
import com.capstone.realmen.repository.database.branch.display.BranchDisplayEntity;
import com.capstone.realmen.util.mappers.DTOMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BranchDisplayMapper extends DTOMapper<BranchDisplay, BranchDisplayEntity> {
    @Mapping(target = "branchId", source = "branchId")
    BranchDisplayEntity create(BranchDisplay dto, Long branchId, Auditable auditable);
}
