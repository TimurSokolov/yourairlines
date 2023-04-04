package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.AuthenticationDto;
import com.airlines.yourairlines.dto.UserDetails;
import com.airlines.yourairlines.entity.User;
import com.airlines.yourairlines.exception.NotFoundException;
import com.airlines.yourairlines.exception.ValidationException;
import com.airlines.yourairlines.repository.IBaseRepository;
import com.airlines.yourairlines.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudService<User> implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private UserDetailsContextService userDetailsContextService;

    @Override
    public IBaseRepository<User> getRepository() {
        return userRepository;
    }

    @Override
    protected void validate(User entity) {

    }

    @Override
    public boolean register(AuthenticationDto authenticationDto) {

        if (authenticationDto.getLogin() == null || authenticationDto.getPassword() == null) {
            throw new ValidationException("Логин и/или пароль отсутствуют");
        }

        if (authenticationDto.getLogin().isEmpty() || authenticationDto.getPassword().isEmpty()) {
            throw new ValidationException("Логин и/или пароль пустые");
        }

        if (loginIsExist(authenticationDto.getLogin())) {
            throw new ValidationException("Логин уже существует");
        }


        User user = new User();
        user.setLogin(authenticationDto.getLogin());
        user.setPassword(authenticationDto.getPassword());

        userRepository.save(user);

        UserDetails userDetails = createUserDetails();
        userDetails.setLogin(authenticationDto.getLogin());
        setUserDetailsContextService(userDetails);
        return true;
    }

    @Override
    public boolean login(AuthenticationDto authenticationDto) {

        if (!loginIsExist(authenticationDto.getLogin())) {
            throw new ValidationException("Вы указали неправильный логин");
        }

        if (!passwordCheckPassed(authenticationDto.getLogin(), authenticationDto.getPassword())) {
            throw new ValidationException("Вы указали неправильный пароль");
        }

        UserDetails userDetails = createUserDetails();
        userDetails.setLogin(authenticationDto.getLogin());
        setUserDetailsContextService(userDetails);
        return true;
    }

    private boolean loginIsExist(String login) {
        try {
            userRepository.findByLogin(login);
        } catch (NotFoundException e) {
            return false;
        }
        return true;
    }

    private boolean passwordCheckPassed(String login, String password) {
        return password.equals(userRepository.findByLogin(login).getPassword());
    }


    public void setUserDetailsContextService(UserDetails userDetails) {
        userDetailsContextService.setUserDetails(userDetails);
    }


    public UserDetails createUserDetails() {
        return new UserDetails();
    }
}
