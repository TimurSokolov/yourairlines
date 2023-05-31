package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.VersionedEntity;

public interface ICrudService<T extends VersionedEntity> {

  T save(T entityToSave);

  T get(Long id);

  void delete(Long id);
}
