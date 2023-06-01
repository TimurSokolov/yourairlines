package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.User;
import com.airlines.yourairlines.repository.IBaseRepository;
import com.airlines.yourairlines.repository.IUserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudService<User> implements IUserService {
  @Autowired private IUserRepository userRepository;

  @Override
  public IBaseRepository<User> getRepository() {
    return userRepository;
  }

  @Override
  protected void validate(User entity) {}

  @Override
  public Optional<User> getByLogin(String login) {
    return userRepository.findByLogin(login);
  }
}
