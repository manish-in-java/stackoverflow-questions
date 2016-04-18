package org.example.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bargain")
@DiscriminatorValue("B")
public class Bargain extends Posting
{
  @Column(name = "price")
  private BigDecimal price;

  Bargain()
  {
    super();
  }

  public Bargain(final LocalDateTime date, final String plan, final BigDecimal price)
  {
    super(date, plan);

    this.price = price;
  }

  public BigDecimal getPrice()
  {
    return price;
  }
}
