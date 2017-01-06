package org.example.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cart")
public class Cart extends Model
{
  @JoinColumn(name = "customer_id", nullable = false)
  @ManyToOne
  private Customer customer;

  @Column(name = "total", precision = 19, scale = 3, updatable = false)
  private BigDecimal total;

  Cart()
  {
    super();
  }

  public Cart(final Customer customer, final BigDecimal total)
  {
    this();

    this.customer = customer;
    this.total = total;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public BigDecimal getTotal()
  {
    return total;
  }
}
