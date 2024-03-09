package com.capstone.realmen.dto.branch.service;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.capstone.realmen.dto.service.barber.BarberService;
import com.capstone.realmen.repository.database.service.barber.BarberServiceEntity;
import com.capstone.realmen.util.mappers.DTOMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BranchServiceMapper extends DTOMapper<BarberService, BarberServiceEntity> {
}
