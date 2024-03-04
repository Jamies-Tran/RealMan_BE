package com.capstone.realmen.controller.mobile.combo.models;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.combo.Combo;
import com.capstone.realmen.util.mappers.ResponseModelMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ComboMobModelResponseMapper extends ResponseModelMapper<ComboMobResponse, Combo>{
    
}
