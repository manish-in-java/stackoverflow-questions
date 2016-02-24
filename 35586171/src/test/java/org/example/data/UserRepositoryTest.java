package org.example.data;

import org.example.domain.Role;
import org.example.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ContextConfiguration("classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserRepositoryTest
{
  private static final String NAME = "Administrator";

  @Autowired
  private UserRepository userRepository;

  @PersistenceContext
  private EntityManager entityManager;

  @Before
  public void setup()
  {
    userRepository.saveAndFlush(new User(NAME, new Role(NAME)));

    entityManager.clear();
  }

  @Test
  public void testFindOne()
  {
    validate(userRepository.findOne(1L));
  }

  @Test
  public void testFindByName()
  {
    validate(userRepository.findByName(NAME));
  }

  private void validate(final User user)
  {
    Assert.assertNotNull(user);
    Assert.assertNotNull(user.getID());
    Assert.assertNotNull(user.getName());
    Assert.assertNotNull(user.getRole());
    Assert.assertNotNull(user.getRole().getID());
    Assert.assertNotNull(user.getRole().getName());
  }
}
