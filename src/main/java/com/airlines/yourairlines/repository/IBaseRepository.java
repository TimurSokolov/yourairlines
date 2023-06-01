package com.airlines.yourairlines.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<T> extends CrudRepository<T, Long> {}
