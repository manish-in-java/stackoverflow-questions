package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CarFactoryTest
{
  @Autowired
  private CarFactory factory;

  @Test
  public void testContextLoads()
  {
  }

  @Test
  public void testCreateCar()
  {
    final String make = UUID.randomUUID().toString();

    final Car car = factory.createCar(make);

    assertNotNull(car);
    assertTrue(make.equals(car.getMake()));
  }
}
