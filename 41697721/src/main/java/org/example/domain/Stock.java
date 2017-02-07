package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@QueryEntity
public class Stock extends Model
{
  @Column(name = "product", nullable = false)
  private String product;

  @Column(name = "quantity", nullable = false)
  private int quantity;

  @JoinColumn(name = "store_id", nullable = false)
  @ManyToOne
  private Store store;

  Stock()
  {
    super();
  }

  public Stock(final Store store, final String product, final int quantity)
  {
    this();

    this.product = product;
    this.quantity = quantity;
    this.store = store;
  }

  public String getProduct()
  {
    return product;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public Store getStore()
  {
    return store;
  }
}
