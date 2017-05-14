package org.example.data;

import org.example.domain.Sector;

public interface SectorRepository extends ModelRepository<Sector>
{
  Sector findByNombre(String nombre);
}
