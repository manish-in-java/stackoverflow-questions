package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@QueryEntity
@Table(name = "attribute")
public class Attribute extends Model
{
  @Column(length = 100, name = "name", nullable = false)
  private String name;

  Attribute()
  {
    super();
  }

  public Attribute(final String name)
  {
    this();

    this.name = name;
  }

  public String getName()
  {
    return name;
  }
}
