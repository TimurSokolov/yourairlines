package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.User;
import com.airlines.yourairlines.service.IUserService;

public abstract class UserController<T extends User> extends CrudController<T> {
    @Override
    public abstract IUserService<T> getService();

}
