package org.example.web;

import org.example.data.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/foo")
public class FooController
{
  @Autowired
  @Lazy
  private FooRepository repository;
}
