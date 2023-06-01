package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.VersionedDto;
import com.airlines.yourairlines.dto.valiation.Create;
import com.airlines.yourairlines.dto.valiation.Update;
import com.airlines.yourairlines.entity.VersionedEntity;
import com.airlines.yourairlines.mapper.EntityMapper;
import com.airlines.yourairlines.service.ICrudService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/** Абстрактный CRUD контроллер */
public abstract class CrudController<T extends VersionedEntity, U extends VersionedDto> {

  public abstract ICrudService<T> getService();

  public abstract EntityMapper<T, U> getMapper();

  @GetMapping("/{id}")
  public U get(@PathVariable Long id) {
    T entity = getService().get(id);
    return getMapper().mapToDto(entity);
  }

  @PostMapping
  public U save(@RequestBody @Validated(Create.class) U dtoToSave) {
    T entity = getMapper().mapToEntity(dtoToSave);
    entity = getService().save(entity);
    return getMapper().mapToDto(entity);
  }

  @PutMapping
  public U update(@RequestBody @Validated(Update.class) U dtoToUpdate) {
    T entity = getMapper().mapToEntity(dtoToUpdate);
    entity = getService().save(entity);
    return getMapper().mapToDto(entity);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    getService().delete(id);
  }
}
