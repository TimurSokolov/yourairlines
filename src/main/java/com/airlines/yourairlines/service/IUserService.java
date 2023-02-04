package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.RegistrationDto;
import com.airlines.yourairlines.dto.User;
import com.airlines.yourairlines.dto.UserDetails;

public interface IUserService<T extends User, U extends UserDetails> extends ICrudService<T> {

    T findUserByLogin(String login);

    boolean register(RegistrationDto registrationDto);

}
