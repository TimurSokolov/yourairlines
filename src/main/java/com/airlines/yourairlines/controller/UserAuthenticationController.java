package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.RegistrationDto;
import com.airlines.yourairlines.dto.User;
import com.airlines.yourairlines.dto.UserDetails;
import com.airlines.yourairlines.service.IUserService;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class UserAuthenticationController<T extends User, U extends UserDetails> {
    public abstract IUserService<T, U> getService();

    public boolean register(@RequestBody RegistrationDto registrationDto) {
        return getService().register(registrationDto);
    }
}
