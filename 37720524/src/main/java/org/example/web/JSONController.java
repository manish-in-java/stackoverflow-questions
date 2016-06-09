package org.example.web;

import org.example.domain.JSONRetriever;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/json")
@RestController
public class JSONController
{
  @RequestMapping(method = RequestMethod.GET)
  public JSONRetriever getJSON(@RequestParam(value = "id", required = false, defaultValue = "URL") String id)
  {
    return new JSONRetriever(id);
  }
}
