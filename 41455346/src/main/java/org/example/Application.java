package org.example;

import com.google.gson.GsonBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application
{
  public static void main(String[] args)
  {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public RestTemplate restTemplate()
  {
    //final GsonHttpMessageConverter messageConverter = new GsonHttpMessageConverter();
    //messageConverter.setGson(new GsonBuilder().setPrettyPrinting().create());

    final RestTemplate restTemplate = new RestTemplate();
    //restTemplate.getMessageConverters().add(messageConverter);

    return restTemplate;
  }
}
