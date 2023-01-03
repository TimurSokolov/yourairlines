package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.LongIdDto;
import com.airlines.yourairlines.repository.ICrudRepository;

/**
 * Абстрактные CRUD сервисы
 */
public abstract class CrudService<T extends LongIdDto> implements ICrudService<T> {

    public abstract ICrudRepository<T> getRepository();

    protected abstract void validate(T dto);


    @Override
    public T save(T dtoToSave) {

        if (dtoToSave.getId() != null) {
            throw new RuntimeException("Ошибка сохранения");
        }

        validate(dtoToSave);
        return getRepository().save(dtoToSave);
    }

    @Override
    public T update(T dtoToUpdate) {

        if (dtoToUpdate.getId() == null) {
            throw new RuntimeException("Ошибка обновления");
        }

        validate(dtoToUpdate);
        return getRepository().update(dtoToUpdate);
    }

    @Override
    public T get(Long id) {
        return getRepository().findOne(id);
    }

    @Override
    public void delete(Long id) {
        getRepository().delete(id);
    }
}
