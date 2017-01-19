package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@QueryEntity
@Table(name = "company")
public class Company extends Model
{
  @Column(name = "name", nullable = false)
  private String name;

  Company()
  {
    super();
  }

  public Company(final String name)
  {
    this();

    this.name = name;
  }

  public String getName()
  {
    return name;
  }
}
