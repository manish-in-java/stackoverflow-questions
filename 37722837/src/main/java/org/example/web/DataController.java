package org.example.web;

import org.example.domain.Data;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/data")
@RestController
public class DataController
{
  @RequestMapping(method = RequestMethod.POST)
  public Data getData(@RequestBody final Data data)
  {
    return data;
  }
}
