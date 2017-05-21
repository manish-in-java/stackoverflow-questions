package org.example;

import org.example.web.converter.CsvHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Collection;
import java.util.List;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport
{
  @Override
  protected void configureMessageConverters(final List<HttpMessageConverter<?>> converters)
  {
    converters.add(csvMessageConverter());

    super.addDefaultHttpMessageConverters(converters);
  }

  @Bean
  public CsvHttpMessageConverter<Collection> csvMessageConverter()
  {
    return new CsvHttpMessageConverter<>();
  }
}
