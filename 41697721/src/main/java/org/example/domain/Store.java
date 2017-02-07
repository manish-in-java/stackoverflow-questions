package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@QueryEntity
public class Store extends Model
{
  @Column(name = "city", nullable = false)
  private String city;

  Store()
  {
    super();
  }

  public Store(final String city)
  {
    this();

    this.city = city;
  }

  public String getCity()
  {
    return city;
  }
}
