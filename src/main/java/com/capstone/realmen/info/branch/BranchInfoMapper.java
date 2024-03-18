package com.capstone.realmen.info.branch;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.branch.Branch;
import com.capstone.realmen.dto.branch.BranchSortCriteria;
import com.capstone.realmen.util.mappers.InfoMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BranchInfoMapper extends InfoMapper<BranchInfo, Branch> {

    @Mapping(target = "distance", expression = "java(distance(fromDes, info))")
    @Mapping(target = "latitude", source = "info.latitude")
    @Mapping(target = "longitude", source = "info.longitude")
    Branch toDto(BranchInfo info, BranchSortCriteria fromDes);

    default Double distance(BranchSortCriteria fromDes, BranchInfo toDes) {

        return fromDes.sorter().contains("distance")
                ? Math.acos(Math.sin(fromDes.latitude()) * Math.cos(toDes.getLatitude())
                        + Math.cos(toDes.getLatitude()) * Math.cos(toDes.getLongitude() - fromDes.longitude()))
                        * 637
                : 0.0;
    }
}
