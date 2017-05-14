package org.example.data;

import org.example.domain.Institucion;
import org.example.domain.Sector;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class InstitucionRepositoryTest
{
  private static final Random RANDOM = new SecureRandom();

  @Autowired
  private InstitucionRepository institucionRepository;
  @Autowired
  private SectorRepository      sectorRepository;

  @Before
  public void setup()
  {
    final Sector one = sectorRepository.saveAndFlush(new Sector("1", "Sector 1"));
    final Sector two = sectorRepository.saveAndFlush(new Sector("2", "Sector 2"));

    institucionRepository.saveAndFlush(new Institucion(one, "11", "Institucion 11"));
    institucionRepository.saveAndFlush(new Institucion(one, "12", "Institucion 12"));
    institucionRepository.saveAndFlush(new Institucion(one, "13", "Institucion 13"));
  }

  @Test
  public void testFindBySector()
  {
    final Sector sector = sectorRepository.findByNombre("1");

    final List<Institucion> instituciones = institucionRepository.findAllBySector(sector);

    assertNotNull(instituciones);
    assertFalse(instituciones.isEmpty());
    instituciones.forEach(institucion ->
                          {
                            assertNotNull(institucion);
                            assertNotNull(institucion.getDescripcion());
                            assertNotNull(institucion.getID());
                            assertNotNull(institucion.getNombre());
                            assertNotNull(institucion.getSector());

                            assertEquals(sector, institucion.getSector());
                          });
  }

  @Test
  public void testFindBySectorId()
  {
    final Sector sector = sectorRepository.findByNombre("1");

    final List<Institucion> instituciones = institucionRepository.findAllBySectorId(sector.getID());

    assertNotNull(instituciones);
    assertFalse(instituciones.isEmpty());
    instituciones.forEach(institucion ->
                          {
                            assertNotNull(institucion);
                            assertNotNull(institucion.getDescripcion());
                            assertNotNull(institucion.getID());
                            assertNotNull(institucion.getNombre());
                            assertNotNull(institucion.getSector());

                            assertEquals(sector, institucion.getSector());
                          });
  }
}
