package org.example.data;

import org.example.domain.Fragrance;
import org.springframework.data.jpa.repository.Query;

public interface FragranceRepository extends ModelRepository<Fragrance>
{
  @Query(nativeQuery = true, value = "SELECT * FROM Fragrance WHERE REPLACE(REPLACE(name, ' &', ''), ''' ', '') = ?1")
  Fragrance findByNameIgnoringSpecialCharacters(String name);
}
