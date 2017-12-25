package org.example.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTests
{
  @Autowired
  private PersonRepository repository;

  @Test
  public void testFindByFirstNameAndLastName()
  {
    assertNotNull(repository.findByFirstNameAndLastName("John", "Smith"));
  }
}
