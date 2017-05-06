package org.example.web;

import org.example.domain.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequestMapping("/")
@RestController
public class GreetingController
{
  @GetMapping
  public Greeting greet()
  {
    return new Greeting("Aloha!", new Date());
  }
}
