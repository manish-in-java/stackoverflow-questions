package org.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.InputStream;

@Controller
@RequestMapping("/csv")
public class FooController
{
  @PostMapping(consumes = "text/csv")
  public void upload(@RequestBody InputStream request)
  {
  }
}
