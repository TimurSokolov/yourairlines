package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.dto.LongIdDto;

public interface ICrudRepository<T extends LongIdDto> {

    T save(T dtoToSave);

    T update(T dtoToUpdate);

    T findOne(Long id);

    void delete(Long id);
}
