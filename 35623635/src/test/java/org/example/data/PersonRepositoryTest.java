package org.example.data;

import org.example.domain.Person;
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
public class PersonRepositoryTest
{
  @Autowired
  private PersonRepository personRepository;

  @PersistenceContext
  private EntityManager entityManager;

  @Before
  public void setup()
  {
    personRepository.saveAndFlush(new Person("John", "Doe"));
    personRepository.saveAndFlush(new Person("John", "Lawrence"));
    personRepository.saveAndFlush(new Person("John", "Smith"));
    personRepository.saveAndFlush(new Person("John", "Williams"));

    entityManager.clear();
  }

  @Test
  public void testFindFirstByFirstName()
  {
    validate(personRepository.findFirstByFirstName("John"));
  }

  @Test
  public void testFindFirst1ByFirstName()
  {
    validate(personRepository.findFirst1ByFirstName("John"));

    Assert.assertEquals(personRepository.findFirstByFirstName("John"), personRepository.findFirst1ByFirstName("John"));
  }

  @Test
  public void testFindTopByFirstName()
  {
    validate(personRepository.findTopByFirstName("John"));

    Assert.assertEquals(personRepository.findFirstByFirstName("John"), personRepository.findTopByFirstName("John"));
  }

  @Test
  public void testFindTop1ByFirstName()
  {
    validate(personRepository.findTop1ByFirstName("John"));

    Assert.assertEquals(personRepository.findTopByFirstName("John"), personRepository.findTop1ByFirstName("John"));
  }

  private void validate(final Person person)
  {
    Assert.assertNotNull(person);
    Assert.assertNotNull(person.getID());
    Assert.assertNotNull(person.getFirstName());
    Assert.assertNotNull(person.getLastName());
  }
}
