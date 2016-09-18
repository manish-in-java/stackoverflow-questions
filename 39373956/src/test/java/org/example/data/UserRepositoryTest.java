package org.example.data;

import org.example.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.SecureRandom;
import java.util.Random;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserRepositoryTest
{
  private static final Random RANDOM = new SecureRandom();

  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  private UserRepository userRepository;

  @Before
  public void setup()
  {
    for (int i = 0; i < RANDOM.nextInt(10); ++i)
    {
      userRepository.saveAndFlush(new User());
    }

    entityManager.clear();
  }

  @Test
  public void testFindAll()
  {
    final Page<User> users = userRepository.findAll("select u from User u", new PageRequest(0, 10));

    assertNotNull(users);
    assertNotEquals(0, users.getTotalElements());
  }
}
