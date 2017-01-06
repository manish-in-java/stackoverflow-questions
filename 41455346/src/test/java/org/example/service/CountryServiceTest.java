package org.example.service;

import org.example.domain.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryServiceTest
{
  @Autowired
  private CountryService service;

  @Test
  public void testGetCountries()
  {
    final List<Country> countries = service.getCountries();

    assertNotNull(countries);
    assertFalse(countries.isEmpty());

    countries.forEach(country ->
                      {
                        assertNotNull(country);
                        assertNotNull(country.getAlpha2Code());
                        assertNotNull(country.getAlpha3Code());
                        assertNotNull(country.getName());
                      });
  }
}
