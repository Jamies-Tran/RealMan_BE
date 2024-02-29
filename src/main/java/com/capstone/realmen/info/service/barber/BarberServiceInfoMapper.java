package com.capstone.realmen.info.service.barber;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.service.barber.BarberService;
import com.capstone.realmen.util.mappers.InfoMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BarberServiceInfoMapper extends InfoMapper<BarberServiceInfo, BarberService> {

}
