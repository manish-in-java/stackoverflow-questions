package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration
{
  @Bean
  public DataSource someDataSource()
  {
    return new DataSource();
  }
}
