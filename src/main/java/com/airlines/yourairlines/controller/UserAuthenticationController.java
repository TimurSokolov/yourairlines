package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.AuthenticationDto;
import com.airlines.yourairlines.dto.User;
import com.airlines.yourairlines.dto.UserDetails;
import com.airlines.yourairlines.service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class UserAuthenticationController<T extends User, U extends UserDetails> {
    public abstract IUserService<T, U> getService();

    public abstract U getUserDetailsContextService();

    @PostMapping("/register")
    public boolean register(@RequestBody AuthenticationDto authenticationDto) {
        return getService().register(authenticationDto);
    }

    @PutMapping("/login")
    public boolean login(@RequestBody AuthenticationDto authenticationDto) {
        return getService().login(authenticationDto);
    }

    @GetMapping("/currentuser")    //todo как сделать регистронезависимым?
    public U getCurrentUserDetails() {
        return getUserDetailsContextService();
    }

    @GetMapping("/logout")
    public void logout(HttpSession httpSession) {
        httpSession.invalidate();
    }


}
