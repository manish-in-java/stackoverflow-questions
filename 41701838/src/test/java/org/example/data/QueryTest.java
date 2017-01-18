package org.example.data;

import org.example.domain.Garage;
import org.example.domain.Motorcycle;
import org.example.domain.Truck;
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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class QueryTest
{
  private static final Random RANDOM = new SecureRandom();

  @Autowired
  private GarageRepository     garageRepository;
  @Autowired
  private MotorcycleRepository motorcycleRepository;
  @Autowired
  private TruckRepository      truckRepository;

  @Before
  public void setup()
  {
    // Add a few garages containing motorcycles.
    for (int i = 0; i < 10 + RANDOM.nextInt(10); ++i)
    {
      final Garage garage = garageRepository.saveAndFlush(new Garage());

      motorcycleRepository.saveAndFlush(new Motorcycle(garage));
    }

    // Add a few garages containing trucks.
    for (int i = 0; i < 10 + RANDOM.nextInt(10); ++i)
    {
      final Garage garage = garageRepository.saveAndFlush(new Garage());

      truckRepository.saveAndFlush(new Truck(garage));
    }

    // Add a few garages containing motorcycles as well as trucks.
    for (int i = 0; i < 10 + RANDOM.nextInt(10); ++i)
    {
      final Garage garage = garageRepository.saveAndFlush(new Garage());

      motorcycleRepository.saveAndFlush(new Motorcycle(garage));
      truckRepository.saveAndFlush(new Truck(garage));
    }
  }

  @Test
  public void testFindGarages()
  {
    // Find garages containing motorcycles.
    final List<Garage> motorcycleGarages = motorcycleRepository.findAllDistinctGarages();

    assertNotNull(motorcycleGarages);
    assertFalse(motorcycleGarages.isEmpty());

    // Find garages containing trucks.
    final List<Garage> truckGarages = truckRepository.findAllDistinctGarages();

    assertNotNull(truckGarages);
    assertFalse(truckGarages.isEmpty());
  }
}
