package org.example.service;

import org.example.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest
{
  @Autowired
  private ProductService service;

  @Test
  public void testSave()
  {
    try
    {
      service.save(new Product("Product"));
    }
    catch (final Exception e)
    {
    }

    assertTrue(service.list().isEmpty());
  }
}
