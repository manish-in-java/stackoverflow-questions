package org.example.domain;

import javax.persistence.*;

@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, length = 10, name = "type")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product extends Model
{
  @Column(length = 100, name = "name", nullable = false)
  private String name;

  @Column(insertable = false, length = 10, name = "type", nullable = false, updatable = false)
  private String type;

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

  public String getType()
  {
    return type;
  }
}
