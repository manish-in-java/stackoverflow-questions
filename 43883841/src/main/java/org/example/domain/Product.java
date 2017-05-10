package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Product extends Model
{
  @Column(name = "name", nullable = false)
  private String name;

  Product()
  {
    super();
  }

  public Product(final String name)
  {
    this();

    this.name = name;
  }

  public String getName()
  {
    return name;
  }
}
