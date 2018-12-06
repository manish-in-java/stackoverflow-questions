package org.example.data;

import org.example.domain.Person;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends ModelRepository<Person>
{
  @Query("SELECT "
      + "    MIN(p.age) "
      + "    , MAX(p.age) "
      + "FROM "
      + "    Person p")
  Object[] findAggregates();
}
