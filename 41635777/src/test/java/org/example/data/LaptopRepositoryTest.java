package org.example.data;

import org.example.domain.Laptop;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class LaptopRepositoryTest
{
  private String serialNumber;

  @Autowired
  private LaptopRepository repository;

  @Before
  public void setup()
  {
    serialNumber = UUID.randomUUID().toString();

    repository.save(new Laptop(serialNumber));
  }

  @Test
  public void testFindBySerialNumber()
  {
    final Laptop laptop = repository.findBySerialNumber(serialNumber);

    assertNotNull(laptop);
    assertNotNull(laptop.getID());
    assertNotEquals(0L, (long) laptop.getID());
    assertNotNull(laptop.getSerialNumber());
    assertEquals(serialNumber, laptop.getSerialNumber());
  }
}
