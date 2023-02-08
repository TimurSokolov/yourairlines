package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.AuthenticationDto;
import com.airlines.yourairlines.dto.User;
import com.airlines.yourairlines.dto.UserDetails;
import com.airlines.yourairlines.exception.NotFoundException;
import com.airlines.yourairlines.exception.ValidationException;
import com.airlines.yourairlines.repository.IUserRepository;

public abstract class UserService<T extends User, U extends UserDetails> extends CrudService<T> implements IUserService<T, U> {


    @Override
    public abstract IUserRepository<T> getRepository();

    public abstract void setUserDetailsContextService(U userDetails);

    public abstract T createNewUser();

    public abstract U createUserDetails();

    @Override
    public T findUserByLogin(String login) {
        return getRepository().findUserByLogin(login);
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


        T user = createNewUser();
        user.setLogin(authenticationDto.getLogin());
        user.setPassword(authenticationDto.getPassword());

        getRepository().save(user);

        U userDetails = createUserDetails();
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

        U userDetails = createUserDetails();
        userDetails.setLogin(authenticationDto.getLogin());
        setUserDetailsContextService(userDetails);
        return true;
    }

    private boolean loginIsExist(String login) {
        try {
            getRepository().findUserByLogin(login);
        } catch (NotFoundException e) {
            return false;
        }
        return true;
    }

    private boolean passwordCheckPassed(String login, String password) {
        return password.equals(getRepository().findUserByLogin(login).getPassword());
    }
}
