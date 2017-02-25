package org.example.data;

import org.example.domain.Location;
import org.example.domain.Measurement;
import org.example.domain.Temperature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TemperatureRepositoryTest<T extends Measurement>
{
  private static final Random RANDOM = new SecureRandom();

  @Autowired
  private LocationRepository    locationRepository;
  @Autowired
  private TemperatureRepository temperatureRepository;

  @Before
  public void setup()
  {
    for (int i = 0; i < getInt(); ++i)
    {
      final Location location = locationRepository.save(new Location(getString()));

      for (int j = 0; j < getInt(); ++j)
      {
        temperatureRepository.save(new Temperature(location, new Date(), new BigDecimal(getInt())));
      }
    }
  }

  @Test
  public void testGetMaximumValue()
  {
    final List<Location> locations = locationRepository.findAll();

    assertNotNull(locations);
    assertFalse(locations.isEmpty());

    locations.forEach(location ->
                      {
                        assertNotNull(location);
                        assertNotNull(location.getID());
                        assertNotNull(location.getName());

                        assertNotNull(temperatureRepository.findMaximumValue(location));
                        assertNotNull(temperatureRepository.findMinimumValue(location));
                      });
  }

  private int getInt()
  {
    return 10 + RANDOM.nextInt(10);
  }

  private String getString()
  {
    return UUID.randomUUID().toString();
  }
}
