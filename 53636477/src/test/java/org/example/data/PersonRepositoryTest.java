package org.example.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PersonRepositoryTest
{
  @Autowired
  private PersonRepository repository;

  @Test
  public void testFindAggregates()
  {
    final Object[] aggregates = repository.findAggregates();

    assertNotNull(aggregates);
    assertEquals(1, aggregates.length);
  }
}
