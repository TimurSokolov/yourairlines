package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.User;
import com.airlines.yourairlines.dto.UserDetails;
import com.airlines.yourairlines.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public abstract class UserController<T extends User, U extends UserDetails> extends CrudController<T> {

    public abstract IUserService<T, U> getService();

    @GetMapping("/finduserbylogin")
    public T findByLogin(@RequestParam String login) {
        return getService().findUserByLogin(login);
    }
}
