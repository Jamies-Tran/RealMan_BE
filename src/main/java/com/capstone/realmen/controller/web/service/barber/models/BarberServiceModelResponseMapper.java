package com.capstone.realmen.controller.web.service.barber.models;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.service.barber.BarberService;
import com.capstone.realmen.util.mappers.ResponseModelMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BarberServiceModelResponseMapper extends  ResponseModelMapper<BarberServiceResponse, BarberService>{
    
}
