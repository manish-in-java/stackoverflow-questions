package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.*;

@Entity
@QueryEntity
@Table(name = "product_attribute")
public class ProductAttribute extends Model
{
  @JoinColumn(name = "attribute_id", nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private Attribute attribute;

  @JoinColumn(name = "product_id", nullable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private Product product;

  @Column(length = 100, name = "value", nullable = false)
  private String value;

  ProductAttribute()
  {
    super();
  }

  public ProductAttribute(final Product product, final Attribute attribute, final String value)
  {
    this();

    this.attribute = attribute;
    this.product = product;
    this.value = value;
  }

  public Attribute getAttribute()
  {
    return attribute;
  }

  public Product getProduct()
  {
    return product;
  }

  public String getValue()
  {
    return value;
  }
}
