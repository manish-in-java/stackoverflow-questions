package org.example.data;

import org.example.domain.Equipment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public abstract class EquipmentRepositoryTest<T extends Equipment>
{
  @Before
  public void setup()
  {
    getRepository().saveAndFlush(getEquipment());
  }

  @Test
  public void testFindAll()
  {
    final List<T> results = getRepository().findAll();

    assertNotNull(results);
    assertFalse(results.isEmpty());
    results.forEach(equipment ->
                    {
                      assertNotNull(equipment.getID());
                      assertNotNull(equipment.getMake());
                      assertNotNull(equipment.getModel());
                      assertNotNull(equipment.getSerialNumber());
                    });
  }

  protected abstract T getEquipment();

  protected abstract EquipmentRepository<T> getRepository();

  protected String getRandomString()
  {
    return UUID.randomUUID().toString();
  }
}
