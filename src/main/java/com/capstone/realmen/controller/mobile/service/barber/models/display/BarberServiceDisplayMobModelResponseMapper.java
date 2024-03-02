package com.capstone.realmen.controller.mobile.service.barber.models.display;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.service.barber.display.BarberServiceDisplay;
import com.capstone.realmen.util.mappers.ResponseModelMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BarberServiceDisplayMobModelResponseMapper
        extends ResponseModelMapper<BarberServiceDisplayMobResponse, BarberServiceDisplay> {

}
