package org.example.data;

import org.example.domain.Category;
import org.example.domain.CategoryDetail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CategoryRepositoryTest
{
  @Autowired
  private CategoryRepository       categoryRepository;
  @Autowired
  private CategoryDetailRepository categoryDetailRepository;

  @Before
  public void setup()
  {
    categoryRepository.save(new Category(UUID.randomUUID().toString()
        , categoryDetailRepository.save(new CategoryDetail(UUID.randomUUID().toString()))));
  }

  @Test
  public void testFindAll()
  {
    Iterable<Category> categories = categoryRepository.findAll();

    assertNotNull(categories);
    assertTrue(categories.iterator().hasNext());

    for (Category category : categories)
    {
      assertNotNull(category);
      assertNotNull(category.getName());
      assertNotNull(category.getDetail());
      assertNotNull(category.getDetail().getDescription());
    }
  }
}
