package org.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home page controller.
 */
@Controller
public class HomeController
{
  /**
   * Displays the home page.
   */
  @RequestMapping("/")
  public String home()
  {
    return "home";
  }
}
