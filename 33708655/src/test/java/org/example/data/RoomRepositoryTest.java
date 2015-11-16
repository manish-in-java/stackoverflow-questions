package org.example.data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class RoomRepositoryTest
{
  @Autowired
  private RoomRepository repository;

  @Test
  public void testFindWithDates()
  {
    Assert.assertTrue(repository.findWithDates(new Date(), new Date(), 1L).isEmpty());
  }
}
