package org.example.data;

import org.example.domain.Algo;
import org.example.domain.Rec;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class AssociationTest
{
  @Autowired
  private AlgoRepository algoRepository;

  @Test
  public void testAssociation()
  {
    final Rec rec = new Rec();

    final Algo algo = new Algo();
    algo.addRec(rec);

    algoRepository.saveAndFlush(algo);

    assertNotNull(algo.getID());
    assertFalse(algo.getRecs().isEmpty());
    assertNotNull(algo.getRecs());

    assertNotNull(rec.getID());
    assertNotNull(rec.getAlgo());

    algoRepository.delete(algo);

    assertEquals(0, algoRepository.count());
  }
}
