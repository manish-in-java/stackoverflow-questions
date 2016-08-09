package org.example.data;

import org.example.domain.Product;
import org.example.domain.ProductDetail;
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
public class ProductRepositoryTest
{
  @Autowired
  private ProductRepository       productRepository;
  @Autowired
  private ProductDetailRepository productDetailRepository;

  @Before
  public void setup()
  {
    productRepository.save(new Product(UUID.randomUUID().toString()
        , productDetailRepository.save(new ProductDetail(UUID.randomUUID().toString()))));
  }

  @Test
  public void testFindAll()
  {
    Iterable<Product> products = productRepository.findAll();

    assertNotNull(products);
    assertTrue(products.iterator().hasNext());

    for (Product product : products)
    {
      assertNotNull(product);
      assertNotNull(product.getName());
      assertNotNull(product.getDetail());
      assertNotNull(product.getDetail().getDescription());
    }
  }
}
