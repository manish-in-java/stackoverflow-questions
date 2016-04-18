package org.example.web;

import org.example.data.CompanyRepository;
import org.example.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController
{
  @Autowired
  private CompanyRepository repository;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Response> list()
  {
    return new ResponseEntity<>(new Response(repository.getAll()), HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Void> save(@RequestBody final Company company)
  {
    repository.save(company);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  public class Response
  {
    private List<Company> companies;

    Response(final List<Company> companies)
    {
      this.companies = companies;
    }

    public List<Company> getCompanies()
    {
      return companies;
    }
  }
}
