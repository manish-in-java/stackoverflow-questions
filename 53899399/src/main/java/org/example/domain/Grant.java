package org.example.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "grant")
public class Grant extends Model
{
  @Column(name = "grant_amount", nullable = false)
  private BigDecimal amount;

  @Column(name = "grant_date", nullable = false)
  private Date date;

  @JoinColumn(name = "org_name", nullable = false, referencedColumnName = "org_name")
  @OneToOne
  private Organization organization;

  Grant()
  {
    super();
  }

  public Grant(final Organization organization, final Date date, final BigDecimal amount)
  {
    this.amount = amount;
    this.date = date;
    this.organization = organization;

    organization.setGrant(this);
  }

  public BigDecimal getAmount()
  {
    return amount;
  }

  public Date getDate()
  {
    return date;
  }

  public Organization getOrganization()
  {
    return organization;
  }
}
