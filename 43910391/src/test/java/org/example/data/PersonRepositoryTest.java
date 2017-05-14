package org.example.data;

import org.example.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PersonRepositoryTest
{
  private static final Random RANDOM = new SecureRandom();

  @Autowired
  private PersonRepository repository;

  @Test
  public void testFindAllByAnniversary()
  {
    // Add some random number of records for yesterday.
    IntStream.range(0, getInt())
             .forEach(i -> repository.saveAndFlush(new Person(getString(), yesterday())));

    // Add some random number of records for tomorrow.
    IntStream.range(0, getInt())
             .forEach(i -> repository.saveAndFlush(new Person(getString(), tomorrow())));

    // Add some random number of records for today.
    final int records = getInt();
    IntStream.range(0, records)
             .forEach(i -> repository.saveAndFlush(new Person(getString(), today())));

    // Find all records with an anniversary today.
    final List<Person> persons = repository.findAllByAnniversary();

    assertNotNull(persons);
    assertFalse(persons.isEmpty());
    persons.forEach(person ->
                    {
                      assertNotNull(person.getDob());
                      assertNotNull(person.getID());
                      assertNotNull(person.getName());
                      assertEquals(today(), person.getDob());
                    });
  }

  private int getInt()
  {
    return 10 + RANDOM.nextInt(10);
  }

  private String getString()
  {
    return new BigInteger(130, RANDOM).toString(32);
  }

  private LocalDate today()
  {
    return LocalDate.now();
  }

  private LocalDate tomorrow()
  {
    return today().plusDays(1);
  }

  private LocalDate yesterday()
  {
    return today().minusDays(1);
  }
}
