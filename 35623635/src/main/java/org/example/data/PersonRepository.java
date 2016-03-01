package org.example.data;

import org.example.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>
{
  Person findFirstByFirstName(String name);

  Person findFirst1ByFirstName(String name);

  Person findTopByFirstName(String name);

  Person findTop1ByFirstName(String name);
}
