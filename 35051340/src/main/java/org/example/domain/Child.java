package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "child")
public class Child extends Parent
{
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  public Child(final String name, final String info)
  {
    super();

    setName(name);
    setInfo(info);
  }

  public Long getID()
  {
    return id;
  }

  @Access(AccessType.PROPERTY)
  @Column(name = "name")
  @Size(max = 100)
  public String getName()
  {
    return super.getName();
  }

  @Access(AccessType.PROPERTY)
  @Column(name = "info")
  @Size(max = 4000)
  public String getInfo()
  {
    return super.getInfo();
  }
}
