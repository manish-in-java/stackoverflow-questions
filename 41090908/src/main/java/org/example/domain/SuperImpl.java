package org.example.domain;

import javax.persistence.Entity;

@Entity
public class SuperImpl extends Super
{
  private String superName;

  @Override
  public String getSuperName()
  {
    return superName;
  }

  @Override
  public void setSuperName(String superName)
  {
    this.superName = superName;
  }
}
