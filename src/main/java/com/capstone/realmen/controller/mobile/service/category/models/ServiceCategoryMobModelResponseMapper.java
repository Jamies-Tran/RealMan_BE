package com.capstone.realmen.controller.mobile.service.category.models;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.capstone.realmen.dto.service.category.ServiceCategory;
import com.capstone.realmen.util.mappers.ResponseModelMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceCategoryMobModelResponseMapper
        extends ResponseModelMapper<ServiceCategoryMobResponse, ServiceCategory> {

}
