package org.example.service;

import org.example.api.groupkt.CountryResponse;
import org.example.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CountryService
{
  private static final String URL = "http://services.groupkt.com/country/get/all";

  @Autowired
  private RestTemplate restTemplate;

  public List<Country> getCountries()
  {
    final ResponseEntity<CountryResponse> response = restTemplate.getForEntity(URL, CountryResponse.class);

    return response
        .getBody()
        .getRestResponse()
        .getResult();
  }
}
