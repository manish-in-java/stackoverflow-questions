package org.example.data;

import org.example.domain.Chair;
import org.example.domain.Desk;
import org.example.domain.Lamp;
import org.example.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ProductSortingTest
{
  @Autowired
  private ChairRepository      chairRepository;
  @Autowired
  private DeskRepository       deskRepository;
  @Autowired
  private LampRepository       lampRepository;
  @Autowired
  @Qualifier("productRepository")
  private ProductRepository<?> productRepository;

  @Before
  public void setup()
  {
    // Save some lamps.
    lampRepository.saveAndFlush(new Lamp("Halogen lamp"));
    lampRepository.saveAndFlush(new Lamp("Neon lamp"));

    // Save some desks.
    deskRepository.saveAndFlush(new Desk("Computer desk"));
    deskRepository.saveAndFlush(new Desk("Executive desk"));
    deskRepository.saveAndFlush(new Desk("Writing desk"));

    // Save some chairs.
    chairRepository.saveAndFlush(new Chair("Armchair"));
    chairRepository.saveAndFlush(new Chair("Bench"));
    chairRepository.saveAndFlush(new Chair("Sofa"));
  }

  @Test
  public void testFindAllOrderByType()
  {
    final List<? extends Product> products = productRepository.findAll(new Sort("type"));

    assertNotNull(products);
    assertFalse(products.isEmpty());

    for (final Product product : products)
    {
      assertNotNull(product);
      assertNotNull(product.getID());
      assertNotNull(product.getName());
    }
  }
}
