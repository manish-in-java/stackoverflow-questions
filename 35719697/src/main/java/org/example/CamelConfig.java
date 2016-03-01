package org.example;

import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.List;

@Configuration
@PropertySource(value = "classpath:example.properties")
public class CamelConfig extends CamelConfiguration
{
  @Value("#{'${names}'.split(',')}")
  private List<String> names;

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
  {
    return new PropertySourcesPlaceholderConfigurer();
  }

  public List<String> getNames()
  {
    return names;
  }
}
