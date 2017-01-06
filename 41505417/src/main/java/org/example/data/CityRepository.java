package org.example.data;

import org.example.domain.City;

public interface CityRepository extends ModelRepository<City>
{
  City findByName(String name);
}
