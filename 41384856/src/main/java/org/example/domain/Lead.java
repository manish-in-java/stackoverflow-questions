package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;
import com.querydsl.core.annotations.QueryInit;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@QueryEntity
@Table(name = "lead")
public class Lead extends Model
{
  @JoinColumn(name = "employee_id", nullable = false)
  @ManyToOne
  @QueryInit("*.*")
  private Employee employee;

  @Column(name = "probability", precision = 19, scale = 3)
  protected BigDecimal probability;

  Lead()
  {
    super();
  }

  public Lead(final Employee employee, final BigDecimal probability)
  {
    this();

    this.employee = employee;
    this.probability = probability;
  }

  public Employee getEmployee()
  {
    return employee;
  }

  public BigDecimal getProbability()
  {
    return probability;
  }
}
