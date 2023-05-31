package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.AuthRequest;
import com.airlines.yourairlines.dto.AuthResponse;
import com.airlines.yourairlines.dto.RegisterRequest;

public interface IAuthService {

  AuthResponse register(RegisterRequest registerRequest);

  AuthResponse login(AuthRequest authRequest);
}
