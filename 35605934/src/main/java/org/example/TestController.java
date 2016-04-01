package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController
{
  @RequestMapping(value = "/echo", method = RequestMethod.GET, headers = "Accept=*/*")
  @ResponseBody
  public String echo()
  {
    return "echo";
  }

  @RequestMapping(value = "/test", method = RequestMethod.GET, headers = "Accept=*/*")
  @ResponseBody
  public boolean test()
  {
    return false;
  }
}
