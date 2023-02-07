package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.User;
import com.airlines.yourairlines.dto.UserDetails;

public abstract class UserController<T extends User, U extends UserDetails> extends CrudController<T> {

}
