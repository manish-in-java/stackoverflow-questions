package org.example.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Super extends BaseImpl
{
  public abstract String getSuperName();

  public abstract void setSuperName(String superName);
}
