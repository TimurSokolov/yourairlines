package com.airlines.yourairlines.dto;

import com.airlines.yourairlines.enums.Role;
import java.util.Collection;
import java.util.Collections;
import javax.security.auth.Subject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
public class UserDetails implements Authentication {
  private String login;
  private String name;
  private Role role;
  private boolean authenticated;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singleton(role);
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getDetails() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return null;
  }

  @Override
  public boolean isAuthenticated() {
    return authenticated;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    this.authenticated = isAuthenticated;
  }

  @Override
  public boolean implies(Subject subject) {
    return Authentication.super.implies(subject);
  }
}
