package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.RegistrationDto;
import com.airlines.yourairlines.dto.User;
import com.airlines.yourairlines.dto.UserDetails;
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
    public boolean register(RegistrationDto registrationDto) {
        T user = createNewUser();
        user.setLogin(registrationDto.getLogin());
        user.setPassword(registrationDto.getPassword());

        getRepository().save(user);

        U userDetails = createUserDetails();
        userDetails.setLogin(registrationDto.getLogin());
        setUserDetailsContextService(userDetails);
        return true;
    }



}
