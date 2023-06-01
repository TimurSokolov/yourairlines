package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.crypto.SecretKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtProvider {
  private final SecretKey jwtAccessSecret;

  public JwtProvider(@Value("${jwt.secret.access}") String jwtAccessSecret) {
    this.jwtAccessSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtAccessSecret));
  }

  public String generateAccessToken(User user) {
    final LocalDateTime now = LocalDateTime.now();
    final Instant accessExpirationInstant =
        now.plusHours(5).atZone(ZoneId.systemDefault()).toInstant();
    final Date accessExpiration = Date.from(accessExpirationInstant);
    return Jwts.builder()
        .setSubject(user.getLogin())
        .setExpiration(accessExpiration)
        .signWith(jwtAccessSecret)
        .claim("roles", user.getRole())
        .compact();
  }

  public boolean validateAccessToken(String accessToken) {
    return validateToken(accessToken, jwtAccessSecret);
  }

  private boolean validateToken(String token, Key secret) {
    try {
      Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token);
      return true;
    } catch (ExpiredJwtException expEx) {
      log.error("Token expired", expEx);
    } catch (UnsupportedJwtException unsEx) {
      log.error("Unsupported jwt", unsEx);
    } catch (MalformedJwtException mjEx) {
      log.error("Malformed jwt", mjEx);
    } catch (SignatureException sEx) {
      log.error("Invalid signature", sEx);
    } catch (Exception e) {
      log.error("invalid token", e);
    }
    return false;
  }

  public Claims getAccessClaims(String token) {
    return getClaims(token, jwtAccessSecret);
  }

  private Claims getClaims(String token, Key secret) {
    return Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token).getBody();
  }
}
