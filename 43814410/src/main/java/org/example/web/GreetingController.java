package org.example.web;

import org.example.domain.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

@RequestMapping("/")
@RestController
public class GreetingController
{
  private static final String[] GREETINGS = { "Hello!", "Aloha!", "Hola!", "Bonjour!", "Ola!" };
  private static final Random   RANDOM    = new SecureRandom();

  @GetMapping
  public Greeting greet()
  {
    return new Greeting(GREETINGS[RANDOM.nextInt(GREETINGS.length)], new Date());
  }
}
