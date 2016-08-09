package org.example.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductDetail extends Model
{
  private String description;

  public ProductDetail(String description)
  {
    this.description = description;
  }

  public String getDescription()
  {
    return description;
  }
}
