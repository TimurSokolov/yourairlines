package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.entity.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends IBaseRepository<User> {
  Optional<User> findByLogin(String login);
}
