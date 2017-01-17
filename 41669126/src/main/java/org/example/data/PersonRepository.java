package org.example.data;

import org.example.domain.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends ModelRepository<Person>
{
  @Modifying
  @Query(value = "DELETE FROM person", nativeQuery = true)
  void myDeleteAll();
}
