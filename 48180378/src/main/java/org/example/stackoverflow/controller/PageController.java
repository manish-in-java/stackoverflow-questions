package org.example.stackoverflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController
{
  @GetMapping("/private")
  public String showPrivatePage()
  {
    return "private";
  }

  @GetMapping("/protected")
  public String showProtectedPage()
  {
    return "protected";
  }

  @GetMapping("/public")
  public String showPublicPage()
  {
    return "public";
  }
}
