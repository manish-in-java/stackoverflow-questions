package org.example.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product extends DescribableModel<ProductDetail>
{
  private String name;

  public Product(String name, ProductDetail detail)
  {
    super(detail);

    this.name = name;
  }

  public String getName()
  {
    return name;
  }
}
