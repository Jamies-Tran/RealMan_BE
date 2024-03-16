package com.capstone.realmen.dto.branch;

import java.util.Objects;

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
    BranchEntity create(
            Branch dto,
            String branchStreet,
            String branchWard,
            String branchDistrict,
            String branchProvince,
            Double latitude,
            Double longitude,
            Auditable auditable);

    @Mapping(target = "distance", expression = "java(distance(fromDes, entity))")
    @Mapping(target = "longitude", source = "entity.longitude")
    @Mapping(target = "latitude", source = "entity.latitude")
    Branch toDto(BranchEntity entity, BranchGeo fromDes);

    default Double distance(BranchGeo fromDes, BranchEntity toDes) {
        return Objects.nonNull(fromDes) ? Math.sqrt(Math.pow((toDes.getLatitude() - fromDes.latitude()), 2.0)
                + Math.pow((toDes.getLongitude() - fromDes.longitude()), 2.0)) : 0.0;
    }
}
