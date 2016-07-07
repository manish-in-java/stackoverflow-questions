package org.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock extends Model
{
  @JoinColumn(name = "product_id", updatable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private Product product;

  @Column(name = "quantity")
  private long quantity = 0;

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

  public long getQuantity()
  {
    return quantity;
  }

  public void setQuantity(final long quantity)
  {
    this.quantity = quantity;
  }
}
