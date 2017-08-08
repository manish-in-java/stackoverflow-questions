package org.example.data;

import org.example.domain.House;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseRepository extends ModelRepository<House>
{
  @Query("SELECT "
      + "  h "
      + "  , COUNT(c) "
      + "  , COUNT(p) "
      + "FROM "
      + "  House h "
      + "LEFT OUTER JOIN "
      + "  h.cars c "
      + "LEFT OUTER JOIN "
      + "  h.persons p "
      + "GROUP BY "
      + "  h")
  List<Object[]> findHouseSummary();
}
