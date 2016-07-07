package org.example.data;

import org.example.domain.Cart;
import org.example.domain.CartItem;
import org.example.domain.Product;
import org.example.domain.Stock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class StockRepositoryTest
{
  private static long CART_QUANTITY  = 1L;
  private static long STOCK_QUANTITY = 10L;

  @Autowired
  private CartRepository    cartRepository;
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private StockRepository   stockRepository;

  private Product phone;
  private Product speaker;
  private Stock   phoneStock;
  private Stock   speakerStock;

  @Before
  public void setup()
  {
    productRepository.saveAndFlush(phone = new Product("Phone"));
    productRepository.saveAndFlush(speaker = new Product("Speaker"));

    stockRepository.saveAndFlush(phoneStock = new Stock(phone, STOCK_QUANTITY));
    stockRepository.saveAndFlush(speakerStock = new Stock(speaker, STOCK_QUANTITY));
  }

  @Test
  public void testCart()
  {
    // Ensure stock availability before performing cart operations.
    assertEquals(STOCK_QUANTITY, phoneStock.getQuantity());
    assertEquals(STOCK_QUANTITY, speakerStock.getQuantity());

    // Generate and save a new cart.
    final Cart cart = new Cart();

    final CartItem phoneItem = new CartItem(cart, phone, phoneStock);
    phoneItem.setQuantity(CART_QUANTITY);
    cart.addItem(phoneItem);

    final CartItem speakerItem = new CartItem(cart, speaker, speakerStock);
    speakerItem.setQuantity(CART_QUANTITY);
    cart.addItem(speakerItem);

    cartRepository.saveAndFlush(cart);

    // Ensure correct stock quantities after performing cart operations.
    assertEquals(STOCK_QUANTITY - CART_QUANTITY, phoneStock.getQuantity());
    assertEquals(STOCK_QUANTITY - CART_QUANTITY, speakerStock.getQuantity());

    // Update cart quantities.
    phoneItem.setQuantity(3 * CART_QUANTITY);
    speakerItem.setQuantity(2 * CART_QUANTITY);

    cartRepository.saveAndFlush(cart);

    // Ensure correct stock quantities after performing cart operations.
    assertEquals(STOCK_QUANTITY - 3 * CART_QUANTITY, phoneStock.getQuantity());
    assertEquals(STOCK_QUANTITY - 2 * CART_QUANTITY, speakerStock.getQuantity());

    // Remove one of the cart items.
    speakerItem.setQuantity(0);
    cartRepository.saveAndFlush(cart);

    // Ensure correct stock quantities after performing cart operations.
    assertEquals(STOCK_QUANTITY - 3 * CART_QUANTITY, phoneStock.getQuantity());
    assertEquals(STOCK_QUANTITY, speakerStock.getQuantity());
  }
}
