package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.annotation.UserAuthenticationControllerLink;
import com.airlines.yourairlines.dto.AuthenticationDto;
import com.airlines.yourairlines.dto.User;
import com.airlines.yourairlines.dto.UserDetails;
import com.airlines.yourairlines.service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;

public abstract class UserAuthenticationController<T extends User, U extends UserDetails> {
    public abstract IUserService<T, U> getService();

    public abstract boolean register(AuthenticationDto authenticationDto);

    public abstract boolean login(AuthenticationDto authenticationDto);

    public abstract U getUserDetailsContextService();

    private Class<T> classType;

    public UserAuthenticationController(Class<T> classType) {
        this.classType = classType;
    }

/*    @PostMapping("/register")             //todo как добавить client employee?
    public boolean register(@RequestBody AuthenticationDto authenticationDto) {
        return getService().register(authenticationDto);
    }*/

/*    @PutMapping("/login")
    public boolean login(@RequestBody AuthenticationDto authenticationDto) {
        return getService().login(authenticationDto);
    }*/

    @GetMapping("/currentUser")
    public U getCurrentUserDetails() {
        return getUserDetailsContextService();
    }

    @GetMapping("/logout")
    public void logout(HttpSession httpSession) {
        httpSession.invalidate();
    }

    private String getUserAuthenticationControllerLink() {
        UserAuthenticationControllerLink annotation = classType.getAnnotation(UserAuthenticationControllerLink.class);
        return annotation.userType();
    }

}
