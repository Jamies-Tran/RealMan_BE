package com.capstone.realmen.controller.web.combo.models;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.combo.Combo;
import com.capstone.realmen.util.mappers.RequestModelMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ComboModelRequestMapper extends RequestModelMapper<ComboRequest, Combo> {
    Combo toDto(ComboUpdateRequest model);
}
