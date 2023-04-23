package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends IBaseRepository<User> {

    Optional<User> findByLogin(String login);
}
