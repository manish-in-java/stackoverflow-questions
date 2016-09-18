package org.example.data;

import org.example.domain.Item;
import org.example.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class AssociationTest
{
  @PersistenceContext
  private EntityManager  entityManager;
  @Autowired
  private UserRepository userRepository;

  @Before
  public void setup()
  {
    final Item item = new Item();

    final User user = new User();
    user.addItem(item);

    userRepository.saveAndFlush(user);

    entityManager.clear();
  }

  @Test
  public void testAssociation()
  {
    final List<User> users = userRepository.findAll();

    assertNotNull(users);
    assertFalse(users.isEmpty());

    users.forEach(user ->
                  {
                    assertNotNull(user.getID());
                    assertFalse(user.getItems().isEmpty());
                    assertNotNull(user.getItems());
                    assertFalse(user.getItems().isEmpty());

                    user.getItems().forEach(item ->
                                            {
                                              assertNotNull(item.getID());
                                              assertNotNull(item.getUser());
                                              assertNotNull(item.getUserID());
                                              assertEquals(user.getID(), item.getUserID());
                                            });
                  });
  }
}
