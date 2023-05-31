package com.airlines.yourairlines.utils;

import com.airlines.yourairlines.dto.UserDetails;
import com.airlines.yourairlines.enums.Role;
import io.jsonwebtoken.Claims;

public class JwtUtils {

  public static UserDetails generate(Claims claims) {
    final UserDetails userDetails = new UserDetails();
    userDetails.setRole(Role.valueOf(claims.get("roles", String.class)));
    userDetails.setName(claims.get("name", String.class));
    return userDetails;
  }
}
