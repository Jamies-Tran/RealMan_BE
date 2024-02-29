package com.capstone.realmen.info.service.category;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.capstone.realmen.dto.service.barber.BarberService;
import com.capstone.realmen.dto.service.category.ServiceCategory;
import com.capstone.realmen.util.mappers.InfoMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceCategoryInfoMapper extends InfoMapper<ServiceCategoryInfo, ServiceCategory>{
    ServiceCategory toDto(ServiceCategoryInfo info, List<BarberService> barberServices);
}
