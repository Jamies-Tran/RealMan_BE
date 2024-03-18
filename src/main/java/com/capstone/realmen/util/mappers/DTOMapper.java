package com.capstone.realmen.util.mappers;

import org.mapstruct.Mapping;

import com.capstone.realmen.dto.auditable.Auditable;

public interface DTOMapper<D, E> {
    D toDto(E entity);

    E toEntity(D dto);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    E create(D dto, Auditable auditable);
}
