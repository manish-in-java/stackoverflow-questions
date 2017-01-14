package org.example.data;

import org.example.domain.Fragrance;
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
public class FragranceRepositoryTest
{
  @Autowired
  private FragranceRepository repository;

  @Test
  public void testFindByNameIgnoringSpecialCharacters()
  {
    final String name = "Allure Homme Sport";

    repository.saveAndFlush(new Fragrance(name));

    final Fragrance fragrance = repository.findByNameIgnoringSpecialCharacters(name);

    assertNotNull(fragrance);
    assertNotNull(fragrance.getID());
    assertNotNull(fragrance.getName());
  }
}
