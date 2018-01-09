package org.example.data;

import org.example.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTests
{
  @Autowired
  private PersonRepository repository;

  @Test
  public void testFindByFirstName()
  {
    final String firstName = UUID.randomUUID().toString(), lastName = "001:1";

    final Person person = new Person();
    person.setFirstName(firstName);
    person.setLastName(lastName);

    repository.save(person);

    final List<Person> results = repository.findByFirstName(firstName);

    assertNotNull(results);
    assertFalse(results.isEmpty());

    results.forEach(person1 -> {
      assertNotNull(person);
      assertNotNull(person.getFirstName());
      assertNotNull(person.getLastName());
      assertEquals(firstName, person.getFirstName());
      assertEquals(lastName, person.getLastName());
    });
  }

  @Test
  public void testFindByFirstNameAndLastName()
  {
    assertNotNull(repository.findByFirstNameAndLastName("John", "Smith"));
  }
}
