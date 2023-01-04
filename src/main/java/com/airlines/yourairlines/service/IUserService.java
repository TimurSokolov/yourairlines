package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.User;

public interface IUserService<T extends User> extends ICrudService<T> {

    T findUserByLogin(String login);
}
