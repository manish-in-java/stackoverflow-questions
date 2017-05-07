package org.example.data;

import org.example.domain.A;
import org.example.domain.B;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ARepositoryTest
{
  @Autowired
  private ARepository repository;

  @Test
  public void testSave()
  {
    final A a = new A();
    final B b = new B(a);

    assertNotNull(repository.save(a));
  }
}
