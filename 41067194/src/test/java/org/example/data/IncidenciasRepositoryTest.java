package org.example.data;

import org.example.domain.Incidencias;
import org.example.domain.TiposIncidencias;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.assertTrue;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
public class IncidenciasRepositoryTest
{
  @Autowired
  private IncidenciasRepository      incidenciasRepository;
  @Autowired
  private TiposIncidenciasRepository tiposIncidenciasRepository;

  private TiposIncidencias defecto;
  private TiposIncidencias mejora;
  private TiposIncidencias riesgo;

  @Before
  public void setup()
  {
    defecto = tiposIncidenciasRepository.save(new TiposIncidencias("Defecto"));
    mejora = tiposIncidenciasRepository.save(new TiposIncidencias("Mejora"));
    riesgo = tiposIncidenciasRepository.save(new TiposIncidencias("Riesgo"));
  }

  @Test
  public void testFindAll()
  {
    for (int i = 0; i < 20; ++i)
    {
      incidenciasRepository.save(new Incidencias(defecto, UUID.randomUUID().toString()));
      incidenciasRepository.save(new Incidencias(mejora, UUID.randomUUID().toString()));
      incidenciasRepository.save(new Incidencias(riesgo, UUID.randomUUID().toString()));
    }

    Long incidenciasID = 0L, tiposIncidenciasID = 0L;

    for (Incidencias incidente : incidenciasRepository.findAll(new Sort("tipo", "id")))
    {
      assertTrue(tiposIncidenciasID == incidente.getTipo().getID()
                 ? incidenciasID <= incidente.getID()
                 : tiposIncidenciasID < incidente.getTipo().getID());

      incidenciasID = incidente.getID();
      tiposIncidenciasID = incidente.getTipo().getID();
    }
  }
}
