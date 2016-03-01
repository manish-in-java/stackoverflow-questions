package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "organization")
public class Organization
{
  @Column(name = "id", updatable = false)
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @Column(name = "name")
  @NotNull
  @Size(max = 50)
  private String name;

  Organization()
  {
    super();
  }

  public Organization(final String name)
  {
    this();

    this.name = name;
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
