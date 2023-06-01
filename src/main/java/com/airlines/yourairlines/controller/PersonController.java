package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.PersonDto;
import com.airlines.yourairlines.entity.Person;
import com.airlines.yourairlines.service.IPersonService;

public abstract class PersonController<T extends Person, V extends PersonDto>
    extends CrudController<T, V> {

  public abstract IPersonService<T> getService();
}
