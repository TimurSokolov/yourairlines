package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.dto.LongIdDto;
import com.airlines.yourairlines.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактный CRUD репозиторий
 */

public abstract class CrudRepository<T extends LongIdDto> implements ICrudRepository<T> {

    List<T> database = new ArrayList<>();

    private Long idSequence;


    @Override
    public T save(T dtoToSave) {
        dtoToSave.setId(++idSequence);
        database.add(dtoToSave);
        return dtoToSave;
    }

    @Override
    public T update(T dtoToUpdate) {
        database.remove(dtoToUpdate);
        database.add(dtoToUpdate);
        return dtoToUpdate;
    }

    @Override
    public T findOne(Long id) {
        for (T dto : database) {
            if (dto.getId().equals(id)) {
                return dto;
            }
        }
        throw new NotFoundException();
    }

    @Override
    public void delete(Long id) {
        database.removeIf(dto -> dto.getId().equals(id));
    }
}
