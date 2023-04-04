package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.AuthenticationDto;

public interface IUserService {

    boolean register(AuthenticationDto authenticationDto);

    boolean login(AuthenticationDto authenticationDto);

}
