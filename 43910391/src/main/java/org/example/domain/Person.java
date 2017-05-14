package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Person extends Model
{
  @Column(name = "dob", nullable = false)
  private LocalDate dob;

  @Column(length = 100, name = "name", nullable = false)
  private String name;

  Person()
  {
    super();
  }

  public Person(String name, LocalDate dob)
  {
    this.dob = dob;
    this.name = name;
  }

  public LocalDate getDob()
  {
    return dob;
  }

  public String getName()
  {
    return name;
  }
}
