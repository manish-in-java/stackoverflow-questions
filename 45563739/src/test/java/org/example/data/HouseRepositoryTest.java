package org.example.data;

import org.example.domain.Car;
import org.example.domain.House;
import org.example.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class HouseRepositoryTest
{
  private static final Random RANDOM = new SecureRandom();

  @Autowired
  private CarRepository    carRepository;
  @Autowired
  private HouseRepository  houseRepository;
  @Autowired
  private PersonRepository personRepository;

  private int houses;

  @Before
  public void setup()
  {
    // Create a random number of houses.
    houses = getInt();

    for (int i = 0; i < houses; ++i)
    {
      final House house = houseRepository.saveAndFlush(new House());

      // Add a random number of cars to each house.
      for (int j = 0; j < getInt(); ++j)
      {
        carRepository.saveAndFlush(new Car(house));
      }

      // Add a random number of persons to each house.
      for (int k = 0; k < getInt(); ++k)
      {
        personRepository.saveAndFlush(new Person(house));
      }
    }
  }

  @Test
  public void testFindHouseSummary()
  {
    final List<Object[]> summary = houseRepository.findHouseSummary();

    assertNotNull(summary);
    assertFalse(summary.isEmpty());
    assertEquals(houses, summary.size());

    summary.forEach(row -> {
      assertNotNull(row);
      assertNotNull(row[0]);
      assertNotNull(row[1]);
      assertNotNull(row[2]);

      assertTrue(row[0] instanceof House);
      assertNotNull(((House) row[0]).getID());

      assertTrue(row[1] instanceof Long);
      assertNotEquals((Long) 0L, (Long) row[1]);

      assertTrue(row[2] instanceof Long);
      assertNotEquals((Long) 0L, (Long) row[2]);
    });
  }

  private int getInt()
  {
    return 10 + RANDOM.nextInt(10);
  }
}
