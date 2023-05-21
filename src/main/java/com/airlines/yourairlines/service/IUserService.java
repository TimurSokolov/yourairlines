package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> getByLogin(String login);

}
