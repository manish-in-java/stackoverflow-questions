package org.example.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class RouterRepositoryTest
{
  @Autowired
  private RouterRepository repository;

  @Test
  public void testFindAllByRouterDetailsObjectType()
  {
    assertNotNull(repository.findAllByRouterDetailsObjectType('A'));
  }
}
