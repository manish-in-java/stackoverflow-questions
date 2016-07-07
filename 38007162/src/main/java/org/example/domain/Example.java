package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "example")
public class Example implements Serializable
{
  @Column(name = "id")
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @Column(name = "cat_id")
  private Long catId;

  @Column(name = "name")
  private String name;

  public Long getCatId()
  {
    return catId;
  }

  public Long getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public void setCatId(Long catId)
  {
    this.catId = catId;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public void setName(String name)
  {
    this.name = name;
  }
}
