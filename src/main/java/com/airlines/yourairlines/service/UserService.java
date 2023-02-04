package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.AuthenticationDto;
import com.airlines.yourairlines.dto.User;
import com.airlines.yourairlines.dto.UserDetails;
import com.airlines.yourairlines.exception.NotFoundException;
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

        try {
            T user = getRepository().findUserByLogin(authenticationDto.getLogin());
        } catch (NotFoundException e) {
            return false;
        }


        U userDetails = createUserDetails();
        userDetails.setLogin(authenticationDto.getLogin());
        setUserDetailsContextService(userDetails);
        return true;
    }
}
