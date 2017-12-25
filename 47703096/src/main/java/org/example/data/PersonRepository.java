package org.example.data;

import org.example.domain.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long>
{
  @Query(value = "SELECT"
      + "  *"
      + "FROM"
      + "  person "
      + "WHERE"
      + "  LOWER(first_name)  = LOWER(?1) "
      + "AND LOWER(last_name) = '001\\:1'"
      , nativeQuery = true)
  List<Person> findByFirstName(String firstName);

  @Query(value = "SELECT"
      + "  *"
      + "FROM"
      + "  person "
      + "WHERE"
      + "  LOWER(first_name)  = LOWER(?1) "
      + "AND LOWER(last_name) = LOWER(?2)"
      , nativeQuery = true)
  List<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
