package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2CollectionHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application
{
  public static void main(String[] args)
  {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public RepositoryRestConfigurer repositoryRestConfigurer()
  {
    return new RepositoryRestConfigurerAdapter()
    {
      public void configureHttpMessageConverters(final List<HttpMessageConverter<?>> messageConverters)
      {
        messageConverters.add(jaxbElementConverter());
      }
    };
  }

  @Bean
  public WebMvcConfigurer webMvcConfigurer()
  {
    return new WebMvcConfigurerAdapter()
    {
      public void configureMessageConverters(final List<HttpMessageConverter<?>> messageConverters)
      {
        messageConverters.add(jaxbElementConverter());
      }
    };
  }

  @Bean
  public HttpMessageConverter jaxbCollectionConverter()
  {
    final List<MediaType> mediaTypes = new ArrayList<>();
    mediaTypes.add(MediaType.APPLICATION_XML);
    mediaTypes.add(MediaType.parseMediaType("application/xml;charset=iso-8859-1"));
    mediaTypes.add(MediaType.parseMediaType("application/xml;charset=UTF-8"));
    mediaTypes.add(MediaType.parseMediaType("application/xml;charset=UTF-16"));
    mediaTypes.add(MediaType.TEXT_XML);
    mediaTypes.add(MediaType.parseMediaType("text/xml;charset=iso-8859-1"));
    mediaTypes.add(MediaType.parseMediaType("text/xml;charset=UTF-8"));
    mediaTypes.add(MediaType.parseMediaType("text/xml;charset=UTF-16"));

    final Jaxb2CollectionHttpMessageConverter converter = new Jaxb2CollectionHttpMessageConverter();
    converter.setSupportedMediaTypes(mediaTypes);

    return converter;
  }

  @Bean
  public HttpMessageConverter jaxbElementConverter()
  {
    final List<MediaType> mediaTypes = new ArrayList<>();
    mediaTypes.add(MediaType.APPLICATION_XML);
    mediaTypes.add(MediaType.parseMediaType("application/xml;charset=iso-8859-1"));
    mediaTypes.add(MediaType.parseMediaType("application/xml;charset=UTF-8"));
    mediaTypes.add(MediaType.parseMediaType("application/xml;charset=UTF-16"));
    mediaTypes.add(MediaType.TEXT_XML);
    mediaTypes.add(MediaType.parseMediaType("text/xml;charset=iso-8859-1"));
    mediaTypes.add(MediaType.parseMediaType("text/xml;charset=UTF-8"));
    mediaTypes.add(MediaType.parseMediaType("text/xml;charset=UTF-16"));

    final Jaxb2RootElementHttpMessageConverter converter = new Jaxb2RootElementHttpMessageConverter();
    converter.setSupportedMediaTypes(mediaTypes);

    return converter;
  }
}
