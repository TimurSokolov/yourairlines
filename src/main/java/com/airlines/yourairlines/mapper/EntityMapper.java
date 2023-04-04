package com.airlines.yourairlines.mapper;

import com.airlines.yourairlines.dto.VersionedDto;
import com.airlines.yourairlines.entity.VersionedEntity;

public interface EntityMapper<T extends VersionedEntity, U extends VersionedDto> {
    T mapToEntity(U dto);

    U mapToDto(T entity);
}
