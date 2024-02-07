package com.capstone.realmen.util.mappers;

import com.capstone.realmen.dto.auditable.Auditable;

public interface DTOMapper<D, E> {
    D toDto(E entity);

    E toEntity(D dto);

    E create(D dto, Auditable auditable);
}
