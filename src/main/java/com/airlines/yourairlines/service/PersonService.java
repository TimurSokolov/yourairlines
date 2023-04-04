package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Person;
import com.airlines.yourairlines.repository.IPersonRepository;

public abstract class PersonService<T extends Person> extends CrudService<T> implements IPersonService<T> {

    @Override
    public abstract IPersonRepository<T> getRepository();


}
