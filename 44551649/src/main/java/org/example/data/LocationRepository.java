package org.example.data;

import org.example.domain.Location;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface LocationRepository extends ModelRepository<Location>
{
  Location findByName(String name);

  @Query(nativeQuery = true
      , value = "SELECT "
              + "  r.id "
              + "  , r.latitude "
              + "  , r.longitude "
              + "  , r.name "
              + "FROM "
              + "  (SELECT "
              + "    l.id          AS id "
              + "    , l.latitude  AS latitude "
              + "    , l.longitude AS longitude "
              + "    , l.name      AS name "
              + "    , 2 * 6371 * ASIN(SQRT(POWER(SIN(RADIANS((l.latitude - ?1) / 2)), 2) + COS(RADIANS(l.latitude))*COS(RADIANS(?1))*POWER(SIN(RADIANS((l.longitude - ?2) / 2)), 2))) AS distance "
              + "  FROM "
              + "    location l) AS r "
              + "WHERE "
              + "  r.distance < ?3")
  List<Location> findByProximity(BigDecimal latitude, BigDecimal longitude, BigDecimal distance);
}
