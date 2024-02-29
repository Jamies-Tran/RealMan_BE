package com.capstone.realmen.dto.service.category;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.repository.database.service.category.ServiceCategoryEntity;
import com.capstone.realmen.util.mappers.DTOMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceCategoryMapper extends DTOMapper<ServiceCategory, ServiceCategoryEntity>{
}
