package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock
{
  @Column(name = "id")
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  @SuppressWarnings("unused")
  private Long id;

  @Column(name = "product")
  private String product;

  @Column(name = "quantity")
  private int quantity;

  @Column(name = "reason")
  private String reason;

  Stock()
  {
    super();
  }

  public Stock(final String product, final String reason, final int quantity)
  {
    this();

    this.quantity = quantity;
    this.product = product;
    this.reason = reason;
  }

  public Long getID()
  {
    return id;
  }

  public String getProduct()
  {
    return product;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public String getReason()
  {
    return reason;
  }
}
