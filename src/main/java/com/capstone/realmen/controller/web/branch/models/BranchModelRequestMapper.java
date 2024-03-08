package com.capstone.realmen.controller.web.branch.models;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.branch.Branch;
import com.capstone.realmen.util.mappers.RequestModelMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BranchModelRequestMapper extends RequestModelMapper<BranchRequest, Branch> {

    @Mapping(target = "open", defaultExpression = "java(convertToTime(model.open()))")
    @Mapping(target = "close", defaultExpression = "java(convertToTime(model.close()))")
    Branch toDto(BranchRequest model);

    default LocalTime convertToTime(LocalDateTime fromSource) {
        return fromSource.toLocalTime();
    }
}
