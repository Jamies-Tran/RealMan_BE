package com.capstone.realmen.dto.combo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.auditable.Auditable;
import com.capstone.realmen.repository.database.combo.ComboEntity;
import com.capstone.realmen.util.mappers.DTOMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ComboMapper extends DTOMapper<Combo, ComboEntity>{
    @Mapping(target = "comboId", ignore = true)
    @Mapping(target = "branchId", ignore = true)
    void update(@MappingTarget ComboEntity foundEntity, Combo dto, Auditable auditable);
}
