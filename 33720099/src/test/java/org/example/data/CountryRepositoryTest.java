package org.example.data;

import org.example.domain.City;
import org.example.domain.CitySummary;
import org.example.domain.Country;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CountryRepositoryTest
{
  @PersistenceContext
  private EntityManager     entityManager;
  @Autowired
  private CountryRepository repository;

  private Country country;

  @Before
  public void setup()
  {
    country = new Country("France");

    new City(country, "Paris", BigDecimal.ZERO, BigDecimal.ZERO, 300000L);
    new City(country, "Marseille", BigDecimal.ZERO, BigDecimal.ZERO, 200000L);
    new City(country, "Lyon", BigDecimal.ZERO, BigDecimal.ZERO, 100000L);

    repository.saveAndFlush(country);
    entityManager.clear();
  }

  @After
  public void teardown()
  {
    repository.deleteAllInBatch();
  }

  @Test
  public void testFindAll()
  {
    final List<Country> countries = repository.findAll();

    assertNotNull(countries);
    assertFalse(countries.isEmpty());

    for (final Country country : countries)
    {
      assertNotNull(country);
      assertNotNull(country.getName());

      assertNotNull(country.getCities());
      assertFalse(country.getCities().isEmpty());

      for (final City city : country.getCities())
      {
        assertNotNull(city);
        assertNotNull(city.getLatitude());
        assertNotNull(city.getLongitude());
        assertNotNull(city.getName());
        assertNotNull(city.getPopulation());
      }

      assertNotNull(country.getCitySummaries());
      assertFalse(country.getCitySummaries().isEmpty());

      for (final CitySummary city : country.getCitySummaries())
      {
        assertNotNull(city);
        assertNotNull(city.getName());
      }
    }
  }
}
