package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.dto.User;
import com.airlines.yourairlines.exception.NotFoundException;

public abstract class UserRepository<T extends User> extends CrudRepository<T> implements IUserRepository<T>{

    public T findUserByLogin(String login) {
        for (T dto : database) {
            if (dto.getLogin().equalsIgnoreCase(login)) {
            return dto;
            }
        }
        throw new NotFoundException();
    }
}
