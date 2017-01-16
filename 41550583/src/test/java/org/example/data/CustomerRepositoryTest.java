package org.example.data;

import org.example.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = Config.class)
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CustomerRepositoryTest
{
  @Autowired
  private CustomerRepository repository;

  @Test
  public void testFindAll()
  {
    assertNotNull(repository.findAll());
  }
}
