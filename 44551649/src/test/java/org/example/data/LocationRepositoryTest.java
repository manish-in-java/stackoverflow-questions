package org.example.data;

import org.example.domain.Location;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class LocationRepositoryTest
{
  @Autowired
  private LocationRepository repository;

  @Before
  public void setup()
  {
    repository.saveAndFlush(new Location("Big Ben", 51.5011816, -0.1261141));
    repository.saveAndFlush(new Location("Buckingham Palace", 51.5008413, -0.1457978));
    repository.saveAndFlush(new Location("Greenwich", 51.4765936, 0));
    repository.saveAndFlush(new Location("Heathrow", 51.4619526, -0.4673946));
    repository.saveAndFlush(new Location("Kew Gardens", 51.4775929, -0.2914034));
    repository.saveAndFlush(new Location("Leicester Square", 51.5097594, -0.131436));
    repository.saveAndFlush(new Location("London Eye", 51.5030807, -0.1212545));
    repository.saveAndFlush(new Location("Piccadilly Circus", 51.5093624, -0.1352381));
    repository.saveAndFlush(new Location("Trafalgar Square", 51.5081156, -0.1306832));
    repository.saveAndFlush(new Location("Westminster Abbey", 51.5011816, -0.1261141));
  }

  @Test
  public void testFindByProximity()
  {
    // Designate a point as the center of search.
    final Location center = repository.findByName("Trafalgar Square");

    // Find locations within a 2km radius of the center.
    final List<Location> locations = repository.findByProximity(center.getLatitude(), center.getLongitude(), new BigDecimal(2));

    assertNotNull(locations);
    assertFalse(locations.isEmpty());
    assertEquals(7, locations.size());

    locations.forEach(location ->
                      {
                        assertNotNull(location);
                        assertNotNull(location.getID());
                        assertNotNull(location.getLatitude());
                        assertNotNull(location.getLongitude());
                        assertNotNull(location.getName());
                      });
  }
}
