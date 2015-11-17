package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class CitySummary
{
  @Column(name = "id")
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @JoinColumn(name = "country_id")
  @ManyToOne
  private Country country;

  @Column(name = "name")
  private String name;

  CitySummary()
  {
    super();
  }

  public Long getID()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }
}
