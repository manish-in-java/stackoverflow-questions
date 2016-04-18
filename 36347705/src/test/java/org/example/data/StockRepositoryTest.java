package org.example.data;

import org.example.domain.Stock;
import org.example.domain._Stock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class StockRepositoryTest
{
  @Autowired
  private StockRepository repository;

  @Before
  public void setup()
  {
    repository.save(new Stock("Pepsi", "In", 10));
    repository.save(new Stock("Pepsi", "Out", 2));
    repository.save(new Stock("Pepsi", "In", 15));
    repository.save(new Stock("Pepsi", "Out", 5));

    repository.save(new Stock("Coke", "In", 100));
    repository.save(new Stock("Coke", "Out", 20));
    repository.save(new Stock("Coke", "In", 25));
    repository.save(new Stock("Coke", "Out", 35));
  }

  @Test
  public void testContextLoads()
  {
    final Specification<Stock> specification = new Specification<Stock>()
    {
      @Override
      public Predicate toPredicate(final Root<Stock> root
          , final CriteriaQuery<?> query
          , final CriteriaBuilder builder)
      {

        return null;
      }
    };
  }
}
