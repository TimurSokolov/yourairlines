package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Person;

public interface IPersonService<T extends Person> extends ICrudService<T> {}
