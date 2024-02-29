package com.capstone.realmen.dto.service.barber;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.repository.database.service.barber.BarberServiceEntity;
import com.capstone.realmen.util.mappers.DTOMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BarberServiceMapper extends DTOMapper<BarberService, BarberServiceEntity>{
    
}
