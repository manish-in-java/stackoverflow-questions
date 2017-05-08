package org.example.data;

import org.example.domain.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Random;

import static org.junit.Assert.assertNotEquals;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TaskRepositoryTest
{
  private static final Random RANDOM = new SecureRandom();

  @Autowired
  private TaskRepository repository;

  @Before
  public void setup()
  {
    // Generate some random number of records with some status.
    for (int i = 0; i < getInt(); ++i)
    {
      repository.save(new Task(1));
    }

    // Generate some random number of records with another status.
    for (int i = 0; i < getInt(); ++i)
    {
      repository.save(new Task(2));
    }
  }

  @Test
  public void testDeleteByStatus()
  {
    assertNotEquals(0, repository.deleteByStatus(1));
  }

  private int getInt()
  {
    return 1 + RANDOM.nextInt(20);
  }
}
