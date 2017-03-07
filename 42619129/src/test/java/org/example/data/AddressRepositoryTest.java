package org.example.data;

import org.example.domain.Address;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class AddressRepositoryTest
{
  private static final List<String> CITIES = Arrays.asList("Chicago", "Denver", "Minneapolis");
  private static final Random       RANDOM = new SecureRandom();

  @Autowired
  private AddressRepository repository;

  @Before
  public void setup()
  {
    for (final String city : CITIES)
    {
      for (int i = 0; i < getInt(); ++i)
      {
        repository.saveAndFlush(new Address(city));
      }
    }
  }

  @Test
  public void testFindDistinctCity()
  {
    final List<String> cities = repository.findDistinctCity();

    assertNotNull(cities);
    assertFalse(cities.isEmpty());
    assertEquals(CITIES.size(), cities.size());

    cities.forEach(city ->
                   {
                     assertNotNull(city);
                     assertTrue(CITIES.contains(city));
                   });
  }

  private int getInt()
  {
    return 10 + RANDOM.nextInt(10);
  }
}
