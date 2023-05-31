package com.airlines.yourairlines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories
@EnableScheduling
public class YourAirlinesApplication {

  public static void main(String[] args) {
    SpringApplication.run(YourAirlinesApplication.class, args);
  }
}
