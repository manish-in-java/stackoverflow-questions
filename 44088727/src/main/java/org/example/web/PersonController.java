package org.example.web;

import org.example.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PersonController
{
  @GetMapping("/persons")
  public List<Person> get()
  {
    return Arrays.asList(new Person("Jane", "Smith"), new Person("John", "Smith"));
  }
}
