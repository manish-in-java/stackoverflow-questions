package org.example.service;

import org.example.data.ProductRepository;
import org.example.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService
{
  @Autowired
  private ProductRepository repository;

  public List<Product> searchProducts(final Map<String, String> attributes)
  {
    return repository.findAllByAttributes(attributes);
  }
}
