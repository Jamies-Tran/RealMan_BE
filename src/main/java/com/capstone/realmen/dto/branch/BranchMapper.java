package com.capstone.realmen.dto.branch;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import com.capstone.realmen.dto.auditable.Auditable;
import com.capstone.realmen.repository.database.branch.BranchEntity;
import com.capstone.realmen.util.mappers.DTOMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BranchMapper extends DTOMapper<Branch, BranchEntity> {

    @Mapping(target = "branchStreet", source = "branchStreet")
    @Mapping(target = "branchWard", source = "branchWard")
    @Mapping(target = "branchDistrict", source = "branchDistrict")
    @Mapping(target = "branchProvince", source = "branchProvince")
    @Mapping(target = "latitude", source = "latitude")
    @Mapping(target = "longitude", source = "longitude")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    BranchEntity create(
            Branch dto,
            String branchStreet,
            String branchWard,
            String branchDistrict,
            String branchProvince,
            Double latitude,
            Double longitude,
            Auditable auditable);
}
