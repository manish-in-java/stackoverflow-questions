package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Department extends Model
{
  @Column(length = 100, name = "name", nullable = false)
  private String name;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
}
