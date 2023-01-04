package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.User;
import com.airlines.yourairlines.repository.IUserRepository;

public abstract class UserService<T extends User> extends CrudService<T> implements IUserService<T> {


    @Override
    public abstract IUserRepository<T> getRepository();

    @Override
    public T findUserByLogin(String login) {
        return getRepository().findUserByLogin(login);
    }
}
