package org.example.controller;

import org.example.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/foo")
@RestController
public class FooController
{
  @Autowired
  private FooService service;

  @GetMapping
  public String foo()
  {
    service.foo();

    return "Foo!";
  }
}
