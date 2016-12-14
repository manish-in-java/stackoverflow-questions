package org.example.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Base
{
  public abstract Long getId();

  public abstract void setId(Long id);

  public abstract String getFirstName();

  public abstract void setFirstName(String firstName);
}
