package org.example.controller;

import org.example.domain.Magazine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/magazine")
public class MagazineController extends BaseController<Magazine>
{
  protected Magazine payload()
  {
    return new Magazine("National Geographic");
  }
}
