package com.airlines.yourairlines.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public String string() {
    return "String";
  }
}
