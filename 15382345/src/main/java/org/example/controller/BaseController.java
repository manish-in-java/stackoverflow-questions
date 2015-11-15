package org.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

public abstract class BaseController<T>
{
  @RequestMapping("list")
  public @ResponseBody List<T> list()
  {
    return Collections.singletonList(payload());
  }

  protected abstract T payload();
}
