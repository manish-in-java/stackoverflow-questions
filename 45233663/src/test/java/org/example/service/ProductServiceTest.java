package org.example.service;

import org.example.data.AttributeRepository;
import org.example.data.ProductRepository;
import org.example.domain.Attribute;
import org.example.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@ContextConfiguration("classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ProductServiceTest
{
  @Autowired
  private AttributeRepository attributeRepository;
  @Autowired
  private ProductRepository   productRepository;

  @Autowired
  private ProductService productService;

  @Before
  public void setup()
  {
    final Attribute colour = attributeRepository.saveAndFlush(new Attribute("Colour"));
    final Attribute size = attributeRepository.saveAndFlush(new Attribute("Size"));

    productRepository.saveAndFlush(new Product("Shirt").addAttribute(colour, "Blue").addAttribute(size, "S"));
    productRepository.saveAndFlush(new Product("Shirt").addAttribute(colour, "Blue").addAttribute(size, "M"));
    productRepository.saveAndFlush(new Product("Shirt").addAttribute(colour, "Blue").addAttribute(size, "L"));
    productRepository.saveAndFlush(new Product("Shirt").addAttribute(colour, "Blue").addAttribute(size, "XL"));
    productRepository.saveAndFlush(new Product("Shirt").addAttribute(colour, "Blue").addAttribute(size, "XXL"));

    productRepository.saveAndFlush(new Product("Shirt").addAttribute(colour, "White").addAttribute(size, "S"));
    productRepository.saveAndFlush(new Product("Shirt").addAttribute(colour, "White").addAttribute(size, "M"));
    productRepository.saveAndFlush(new Product("Shirt").addAttribute(colour, "White").addAttribute(size, "L"));
    productRepository.saveAndFlush(new Product("Shirt").addAttribute(colour, "White").addAttribute(size, "XL"));
    productRepository.saveAndFlush(new Product("Shirt").addAttribute(colour, "White").addAttribute(size, "XXL"));

    productRepository.saveAndFlush(new Product("Suit").addAttribute(colour, "Black").addAttribute(size, "S"));
    productRepository.saveAndFlush(new Product("Suit").addAttribute(colour, "Black").addAttribute(size, "M"));
    productRepository.saveAndFlush(new Product("Suit").addAttribute(colour, "Black").addAttribute(size, "L"));
    productRepository.saveAndFlush(new Product("Suit").addAttribute(colour, "Black").addAttribute(size, "XL"));
    productRepository.saveAndFlush(new Product("Suit").addAttribute(colour, "Black").addAttribute(size, "XXL"));

    productRepository.saveAndFlush(new Product("Suit").addAttribute(colour, "Grey").addAttribute(size, "S"));
    productRepository.saveAndFlush(new Product("Suit").addAttribute(colour, "Grey").addAttribute(size, "M"));
    productRepository.saveAndFlush(new Product("Suit").addAttribute(colour, "Grey").addAttribute(size, "L"));
    productRepository.saveAndFlush(new Product("Suit").addAttribute(colour, "Grey").addAttribute(size, "XL"));
    productRepository.saveAndFlush(new Product("Suit").addAttribute(colour, "Grey").addAttribute(size, "XXL"));
  }

  @Test
  public void testSearchProductsWithBlueColour()
  {
    final List<Product> products = productService.searchProducts(Collections.singletonMap("Colour", "Blue"));

    assertNotNull(products);
    assertFalse(products.isEmpty());
    assertEquals(5, products.size());
  }

  @Test
  public void testSearchProductsWithSmallSize()
  {
    final List<Product> products = productService.searchProducts(Collections.singletonMap("Size", "S"));

    assertNotNull(products);
    assertFalse(products.isEmpty());
    assertEquals(4, products.size());
  }

  @Test
  public void testSearchProductsWithWhiteColourAndLargeSize()
  {
    final Map<String, String> attributes = new HashMap<>();
    attributes.put("Colour", "White");
    attributes.put("Size", "L");

    final List<Product> products = productService.searchProducts(attributes);

    assertNotNull(products);
    assertFalse(products.isEmpty());
    assertEquals(1, products.size());
  }
}
