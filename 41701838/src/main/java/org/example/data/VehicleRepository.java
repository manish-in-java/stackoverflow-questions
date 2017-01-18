package org.example.data;

import org.example.domain.Garage;
import org.example.domain.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface VehicleRepository<T extends Vehicle> extends ModelRepository<T>
{
  @Query("SELECT DISTINCT v.garage FROM #{#entityName} v")
  List<Garage> findAllDistinctGarages();
}
