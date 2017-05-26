package org.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class LocationController
{
  @GetMapping("/location")
  public String location(@RequestParam(defaultValue = "0.0") final Double latitude
      , @RequestParam(defaultValue = "0.0") final Double longitude
      , final Model model)
  {
    model.addAttribute("latitude", latitude);
    model.addAttribute("longitude", longitude);

    return "location";
  }
}
