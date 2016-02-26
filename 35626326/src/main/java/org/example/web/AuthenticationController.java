package org.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User authentication controller.
 */
@Controller
public class AuthenticationController
{
  /**
   * Displays the home page on successful login.
   */
  @RequestMapping("/login/continue")
  public String login()
  {
    return "home";
  }

  /**
   * Displays the home page on successful logout.
   */
  @RequestMapping("/logout/continue")
  public String logout()
  {
    return "home";
  }

  /**
   * Displays the login page.
   */
  @RequestMapping("/login")
  public String show()
  {
    return "login";
  }
}
