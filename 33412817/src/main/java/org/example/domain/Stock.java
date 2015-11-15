package org.example.domain;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Stock extends Model
{
  @JoinColumn(name = "product_id", updatable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private Product product;

  @Column(name = "quantity")
  private Long quantity;

  Stock()
  {
    super();
  }

  public Stock(final Product product, final Long quantity)
  {
    this();

    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct()
  {
    return product;
  }

  public Long getQuantity()
  {
    return quantity;
  }

  public void setQuantity(final Long quantity)
  {
    this.quantity = quantity;
  }
}
