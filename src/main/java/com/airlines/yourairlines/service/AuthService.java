package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.AuthRequest;
import com.airlines.yourairlines.dto.AuthResponse;
import com.airlines.yourairlines.dto.RegisterRequest;
import com.airlines.yourairlines.entity.User;
import com.airlines.yourairlines.enums.Role;
import com.airlines.yourairlines.exception.AuthException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService implements IAuthService {

  private final UserService userService;
  private final JwtProvider jwtProvider;

  @Override
  public AuthResponse register(RegisterRequest registerRequest) {
    Optional<User> userOptional = userService.getByLogin(registerRequest.getLogin());

    if (userOptional.isPresent()) {
      throw new AuthException("Пользователь с таким именем уже существует");
    }

    User user =
        User.builder()
            .role(Role.ADMIN)
            .login(registerRequest.getLogin())
            .password(registerRequest.getPassword())
            .build();

    user = userService.save(user);

    final String accessToken = jwtProvider.generateAccessToken(user);
    return new AuthResponse(accessToken);
  }

  @Override
  public AuthResponse login(AuthRequest authRequest) {
    User user =
        userService
            .getByLogin(authRequest.getLogin())
            .orElseThrow(() -> new AuthException("Пользователь не найден"));

    if (user.getPassword().equals(authRequest.getPassword())) {
      final String accessToken = jwtProvider.generateAccessToken(user);
      return new AuthResponse(accessToken);
    } else {
      throw new AuthException("Неправильный пароль");
    }
  }
}
