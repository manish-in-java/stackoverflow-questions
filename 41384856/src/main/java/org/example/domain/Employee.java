package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.*;

@Entity
@QueryEntity
@Table(name = "employee")
public class Employee extends Model
{
  @Column(name = "name", nullable = false)
  private String name;

  @JoinColumn(name = "site_id", nullable = false)
  @ManyToOne
  private Site site;

  Employee()
  {
    super();
  }

  public Employee(final Site site, final String name)
  {
    this();

    this.name = name;
    this.site = site;
  }

  public String getName()
  {
    return name;
  }

  public Site getSite()
  {
    return site;
  }
}
