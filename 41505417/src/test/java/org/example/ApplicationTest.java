package org.example;

import org.example.data.CartRepository;
import org.example.data.CityRepository;
import org.example.data.CustomerRepository;
import org.example.domain.Cart;
import org.example.domain.City;
import org.example.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ApplicationTest
{
  @Autowired
  private CartRepository     cartRepository;
  @Autowired
  private CityRepository     cityRepository;
  @Autowired
  private CustomerRepository customerRepository;

  @Before
  public void setup()
  {
    final City chicago = cityRepository.saveAndFlush(new City("Chicago"));
    final City newYork = cityRepository.saveAndFlush(new City("New York"));
    final City sanFrancisco = cityRepository.saveAndFlush(new City("San Francisco"));

    final Customer james = customerRepository.saveAndFlush(new Customer(chicago, "James Smith"));
    final Customer jeff = customerRepository.saveAndFlush(new Customer(newYork, "Jeff Smith"));
    final Customer john = customerRepository.saveAndFlush(new Customer(sanFrancisco, "John Smith"));

    cartRepository.saveAndFlush(new Cart(james, BigDecimal.ONE));
    cartRepository.saveAndFlush(new Cart(jeff, BigDecimal.TEN));
    cartRepository.saveAndFlush(new Cart(john, BigDecimal.TEN.multiply(BigDecimal.TEN)));
  }

  @Test
  public void testFindAllCartsByCustomerCityName()
  {
    List<Cart> carts = cartRepository.findAllByCustomerCityName("Chicago");

    assertNotNull(carts);
    assertFalse(carts.isEmpty());

    carts = cartRepository.findAllByCustomerCityName("New York");

    assertNotNull(carts);
    assertFalse(carts.isEmpty());

    carts = cartRepository.findAllByCustomerCityName("San Francisco");

    assertNotNull(carts);
    assertFalse(carts.isEmpty());
  }
}
