package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = QueryConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SampleRepositoryTest
{
  @Autowired
  private SampleRepository repository;

  @Test
  public void testFindAllQuery()
  {
    assertNotNull(repository.findAllQuery);
  }
}
