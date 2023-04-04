package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.entity.Person;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IPersonRepository<T extends Person> extends IBaseRepository<T> {

}
