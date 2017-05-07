package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "b")
public class B extends Model
{
  @JoinColumn(name = "a_id")
  @ManyToOne
  private A a;

  B()
  {
    super();
  }

  public B(final A a)
  {
    this();

    this.a = a;
  }
}
