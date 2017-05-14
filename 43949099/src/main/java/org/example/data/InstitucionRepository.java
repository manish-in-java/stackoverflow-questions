package org.example.data;

import org.example.domain.Institucion;
import org.example.domain.Sector;

import java.util.List;

public interface InstitucionRepository extends ModelRepository<Institucion>
{
  List<Institucion> findAllBySector(Sector sector);

  List<Institucion> findAllBySectorId(Long id);
}
