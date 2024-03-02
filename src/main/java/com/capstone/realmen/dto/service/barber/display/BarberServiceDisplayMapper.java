package com.capstone.realmen.dto.service.barber.display;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import com.capstone.realmen.dto.auditable.Auditable;
import com.capstone.realmen.repository.database.service.barber.display.BarberServiceDisplayEntity;
import com.capstone.realmen.util.mappers.DTOMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BarberServiceDisplayMapper extends DTOMapper<BarberServiceDisplay, BarberServiceDisplayEntity> {
    @Mapping(target = "barberServiceId", source = "barberServiceId")
    BarberServiceDisplayEntity create(BarberServiceDisplay dto, Long barberServiceId, Auditable auditable);
}
