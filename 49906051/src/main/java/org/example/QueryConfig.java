package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@Configuration
@PropertySource("classpath:queries.xml")
public class QueryConfig
{
  @Value("${sample.findAll}")
  private String findAllQuery;

  @Bean
  public String findAllQuery()
  {
    return findAllQuery;
  }
}
