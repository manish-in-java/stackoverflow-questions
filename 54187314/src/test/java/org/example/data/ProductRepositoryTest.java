package org.example.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ProductRepositoryTest
{
  @Autowired
  private ProductRepository repository;

  @Test
  public void testFindDistinctCategoryByCustomerNumber()
  {
    assertNotNull(repository.findDistinctCategoryByCustomerNumber("", new PageRequest(0, 10)));
  }
}
