package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.VersionedEntity;
import com.airlines.yourairlines.exception.NotFoundException;
import com.airlines.yourairlines.repository.IBaseRepository;

/**
 * Абстрактные CRUD сервисы
 */
public abstract class CrudService<T extends VersionedEntity> implements ICrudService<T> {

    public abstract IBaseRepository<T> getRepository();

    protected abstract void validate(T entity);


    @Override
    public T save(T entityToSave) {
        validate(entityToSave);
        return getRepository().save(entityToSave);
    }

    @Override
    public T get(Long id) {
        return getRepository().findById(id).orElseThrow(() -> new NotFoundException("Объект с id " + id + " не найден"));
    }

    @Override
    public void delete(Long id) {
        getRepository().deleteById(id);
    }
}
