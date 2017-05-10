package org.example.service;

import org.example.data.ProductRepository;
import org.example.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService
{
  @Autowired
  private ProductRepository repository;

  public List<Product> list()
  {
    return repository.findAll();
  }

  @Transactional
  public Product save(final Product product)
  {
    repository.save(product);

    throw new NullPointerException();
  }
}
