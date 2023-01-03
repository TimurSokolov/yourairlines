package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.LongIdDto;

public interface ICrudService<T extends LongIdDto> {

    T save(T dtoToSave);

    T update(T dtoToUpdate);

    T get(Long id);

    void delete(Long id);

}
