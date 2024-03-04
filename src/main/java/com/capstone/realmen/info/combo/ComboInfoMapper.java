package com.capstone.realmen.info.combo;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.combo.Combo;
import com.capstone.realmen.dto.service.barber.BarberService;
import com.capstone.realmen.util.mappers.InfoMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ComboInfoMapper extends InfoMapper<ComboInfo, Combo> {
    Combo toDto(ComboInfo info, List<BarberService> barberServices);
}
