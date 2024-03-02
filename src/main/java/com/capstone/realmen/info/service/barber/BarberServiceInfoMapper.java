package com.capstone.realmen.info.service.barber;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.service.barber.BarberService;
import com.capstone.realmen.dto.service.barber.display.BarberServiceDisplay;
import com.capstone.realmen.util.mappers.InfoMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BarberServiceInfoMapper extends InfoMapper<BarberServiceInfo, BarberService> {
    BarberService toDto(BarberServiceInfo info, List<BarberServiceDisplay> barberServiceDisplays);
}
