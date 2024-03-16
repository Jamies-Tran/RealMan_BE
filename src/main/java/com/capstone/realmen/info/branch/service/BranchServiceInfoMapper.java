package com.capstone.realmen.info.branch.service;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.branch.service.BranchService;
import com.capstone.realmen.util.mappers.InfoMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BranchServiceInfoMapper extends InfoMapper<BranchServiceInfo, BranchService>{
    
}
