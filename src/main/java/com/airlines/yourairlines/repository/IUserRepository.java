package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.dto.User;

public interface IUserRepository<T extends User> extends ICrudRepository<T> {

    T findUserByLogin(String login);

}
