package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@MappedSuperclass
public abstract class Model
{
  @Column(name = "id")
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  @SuppressWarnings("unused")
  private Long id;

  public Long getId()
  {
    return id;
  }
}
