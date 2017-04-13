package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Employee extends Model
{
  @Column(name = "name")
  private String name;

  Employee()
  {
    super();
  }

  public Employee(final String name)
  {
    this();

    this.name = name;
  }

  public String getName()
  {
    return name;
  }
}
