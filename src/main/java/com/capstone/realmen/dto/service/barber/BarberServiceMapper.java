package com.capstone.realmen.dto.service.barber;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.auditable.Auditable;
import com.capstone.realmen.repository.database.service.barber.BarberServiceEntity;
import com.capstone.realmen.util.mappers.DTOMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BarberServiceMapper extends DTOMapper<BarberService, BarberServiceEntity> {

    @Mapping(target = "barberServiceId", ignore = true)
    void update(@MappingTarget BarberServiceEntity foundEntity, BarberService dto, Auditable auditable);
}
