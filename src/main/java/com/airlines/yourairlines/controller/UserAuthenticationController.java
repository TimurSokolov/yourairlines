package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.AuthRequest;
import com.airlines.yourairlines.dto.AuthResponse;
import com.airlines.yourairlines.dto.RegisterRequest;
import com.airlines.yourairlines.dto.UserDetails;
import com.airlines.yourairlines.service.IAuthService;
import com.airlines.yourairlines.service.UserDetailsContextService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAuthenticationController {
  @Autowired public UserDetailsContextService userDetailsContextService;
  @Autowired private IAuthService authService;

  @PostMapping("/register")
  public AuthResponse register(@RequestBody @Validated RegisterRequest registerRequest) {
    return authService.register(registerRequest);
  }

  @PutMapping("/login")
  public AuthResponse login(@RequestBody @Validated AuthRequest authRequest) {
    return authService.login(authRequest);
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
