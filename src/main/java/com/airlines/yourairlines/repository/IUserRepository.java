package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository<T extends User> extends IBaseRepository<T> {

    T findByLogin(String login);
}
