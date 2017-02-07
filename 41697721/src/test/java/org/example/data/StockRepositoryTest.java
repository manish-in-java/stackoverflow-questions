package org.example.data;

import org.example.domain.Stock;
import org.example.domain.Store;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertNotEquals;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class StockRepositoryTest
{
  private static final List<String> CITIES   = Arrays.asList("Chicago", "Denver", "Detroit");
  private static final List<String> PRODUCTS = Arrays.asList("Balloon", "Cape", "Hat");
  private static final Random       RANDOM   = new SecureRandom();

  @Autowired
  private StockRepository stockRepository;
  @Autowired
  private StoreRepository storeRepository;

  @Before
  public void setup()
  {
    for (final String city : CITIES)
    {
      final Store store = storeRepository.saveAndFlush(new Store(city));

      for (final String product : PRODUCTS)
      {
        stockRepository.saveAndFlush(new Stock(store, product, 1 + RANDOM.nextInt(100)));
      }
    }
  }

  @Test
  public void testFindTotalQuantityByProduct()
  {
    for (final String product : PRODUCTS)
    {
      assertNotEquals(0, stockRepository.findTotalQuantityByProduct(product));
    }
  }
}
