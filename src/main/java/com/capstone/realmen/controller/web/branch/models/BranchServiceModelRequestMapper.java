package com.capstone.realmen.controller.web.branch.models;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.branch.service.BranchService;
import com.capstone.realmen.util.mappers.RequestModelMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BranchServiceModelRequestMapper extends RequestModelMapper<BranchServiceRequest, BranchService>{
    
}
