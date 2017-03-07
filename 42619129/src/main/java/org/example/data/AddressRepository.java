package org.example.data;

import org.example.domain.Address;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends ModelRepository<Address>
{
  @Query("SELECT DISTINCT a.city FROM Address a")
  List<String> findDistinctCity();
}
