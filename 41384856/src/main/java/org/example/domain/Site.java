package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.*;

@Entity
@QueryEntity
@Table(name = "site")
public class Site extends Model
{
  @JoinColumn(name = "company_id", nullable = false)
  @ManyToOne
  private Company company;

  @Column(name = "name", nullable = false)
  private String name;

  Site()
  {
    super();
  }

  public Site(final Company company, final String name)
  {
    this();

    this.company = company;
    this.name = name;
  }

  public Company getCompany()
  {
    return company;
  }

  public String getName()
  {
    return name;
  }
}
