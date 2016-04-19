package org.example.web;

import org.example.data.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/organization")
public class OrganizationController
{
  @Autowired
  private CompanyRepository repository;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<Object>> list()
  {
    return new ResponseEntity<>(repository.listAll(), HttpStatus.OK);
  }
}
