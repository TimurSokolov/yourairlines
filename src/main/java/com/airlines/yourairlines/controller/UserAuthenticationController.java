package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.AuthenticationDto;
import com.airlines.yourairlines.dto.UserDetails;
import com.airlines.yourairlines.service.IUserService;
import com.airlines.yourairlines.service.UserDetailsContextService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAuthenticationController {
    @Autowired
    public UserDetailsContextService userDetailsContextService;
    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public boolean register(@RequestBody AuthenticationDto authenticationDto) {
        return userService.register(authenticationDto);
    }

    @PutMapping("/login")
    public boolean login(@RequestBody AuthenticationDto authenticationDto) {
        return userService.login(authenticationDto);
    }

    @GetMapping("/currentuser")
    public UserDetails getCurrentUserDetails() {
        return userDetailsContextService.getUserDetails();
    }

    @GetMapping("/logout")
    public void logout(HttpSession httpSession) {
        httpSession.invalidate();
    }


}
