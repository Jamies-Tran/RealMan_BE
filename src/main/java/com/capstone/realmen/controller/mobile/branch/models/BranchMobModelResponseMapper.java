package com.capstone.realmen.controller.mobile.branch.models;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.branch.Branch;
import com.capstone.realmen.util.mappers.ResponseModelMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BranchMobModelResponseMapper extends ResponseModelMapper<BranchMobResponse, Branch> {

}
