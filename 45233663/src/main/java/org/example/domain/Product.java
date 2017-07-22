package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@QueryEntity
@Table(name = "product")
public class Product extends Model
{
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
  private Set<ProductAttribute> attributes;

  @Column(length = 100, name = "name", nullable = false)
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

  public Product addAttribute(final Attribute attribute, final String value)
  {
    if (attributes == null)
    {
      attributes = new HashSet<>();
    }

    attributes.add(new ProductAttribute(this, attribute, value));

    return this;
  }

  public String getName()
  {
    return name;
  }

  public Set<ProductAttribute> getAttributes()
  {
    return attributes;
  }
}
