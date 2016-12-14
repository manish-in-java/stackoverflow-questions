package org.example.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseImpl extends Base
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String firstName;

  @Override
  public Long getId()
  {
    return id;
  }

  @Override
  public void setId(Long id)
  {
    this.id = id;
  }

  @Override
  public String getFirstName()
  {
    return firstName;
  }

  @Override
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
}
