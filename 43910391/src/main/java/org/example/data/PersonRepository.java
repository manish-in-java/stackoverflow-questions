package org.example.data;

import org.example.domain.Person;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends ModelRepository<Person>
{
  @Query(nativeQuery = true, value = "SELECT * FROM person WHERE DAY(SYSDATE()) = DAY(dob) AND MONTH(SYSDATE()) = MONTH(dob)")
  List<Person> findAllByAnniversary();
}
