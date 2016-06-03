package org.example.domain;

import java.math.BigDecimal;

public class XnetOrder
{
  private Long       id;
  private BigDecimal total;

  public XnetOrder()
  {
    super();
  }

  public XnetOrder(final Long id)
  {
    this(id, BigDecimal.ZERO);
  }

  public XnetOrder(final Long id, final BigDecimal total)
  {
    this();

    this.id = id;
    setTotal(total);
  }

  public Long getID()
  {
    return id;
  }

  public BigDecimal getTotal()
  {
    return total;
  }

  public void setTotal(final BigDecimal total)
  {
    this.total = total;
  }
}
